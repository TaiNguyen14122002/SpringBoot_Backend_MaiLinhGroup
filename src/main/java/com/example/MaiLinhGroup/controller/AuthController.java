package com.example.MaiLinhGroup.controller;

import com.example.MaiLinhGroup.Service.CustomeUserDetailsImpl;
import com.example.MaiLinhGroup.Service.UserService;
import com.example.MaiLinhGroup.config.JwtProvider;
import com.example.MaiLinhGroup.modal.User;
import com.example.MaiLinhGroup.reponsitory.UserReponsitory;
import com.example.MaiLinhGroup.request.LoginRequest;
import com.example.MaiLinhGroup.request.RegisterRequest;
import com.example.MaiLinhGroup.response.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserReponsitory userReponsitory;

    @Autowired
    private UserService userService;
    @Autowired
    private View error;

    @Autowired
    private CustomeUserDetailsImpl customerUserDatails;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/users")
    public List<User> getUser (){
        List<User> users = userService.getAllUser();
        System.out.println("Users: " + users);
        return userService.getAllUser();
    }

    private Authentication authenticate(String userId, String password) {
        UserDetails userDetails = customerUserDatails.loadUserByUsername(userId);
        if(userDetails == null){
            throw new UsernameNotFoundException("User not found");
        }

//        if(!passwordEncoder.matches(password, userDetails.getPassword())){
//            throw new BadCredentialsException("Wrong password");
//        }

        return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginUserRequest) {

        String userid = loginUserRequest.getUserId();
        String password = loginUserRequest.getPassword();


        // Tìm user trong cơ sở dữ liệu
        User user = userReponsitory.findByUserId(userid);

        // Kiểm tra nếu user không tồn tại
        if (user == null) {
            return new ResponseEntity<>("User not found", HttpStatus.OK);
        }

        // Xác thực thông tin đăng nhập
        Authentication authentication = authenticate(userid, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Tạo token JWT
        String token = JwtProvider.generateToken(authentication);

        // Tạo response
        AuthResponse res = new AuthResponse();
        res.setToken(token);
        res.setUserId(user.getUserId());  // Sử dụng getUserId() từ Lombok
        res.setCreatedDate(user.getCreatedDate());

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) {
        try {
            String userId = registerRequest.getUserId();
            String password = registerRequest.getPassword();
            User registeredUser = userService.registerUser(userId, password);
            return ResponseEntity.ok(registeredUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Đã xảy ra lỗi trong quá trình đăng ký.");
        }
    }

}
