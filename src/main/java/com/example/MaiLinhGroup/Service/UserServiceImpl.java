package com.example.MaiLinhGroup.Service;

import com.example.MaiLinhGroup.config.JwtProvider;
import com.example.MaiLinhGroup.modal.User;
import com.example.MaiLinhGroup.reponsitory.UserReponsitory;
import com.example.MaiLinhGroup.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserReponsitory userReponsitory;


    @Override
    public List<User> getAllUser() {
        List<User> users = userReponsitory.findAll();
        System.out.println("Number of users found: " + users.size());
        return userReponsitory.findAll();
    }

    @Override
    public User findUserProfileByJwt(String jwt) throws Exception {
        // Lấy userId từ token thay vì email
        String userId = JwtProvider.getUserIdFromToken(jwt);
        return userReponsitory.findByUserId(userId);  // Tìm người dùng bằng userId
    }

    @Override
    public User registerUser(String userId, String password) {
        if (userReponsitory.existsByUserId(userId)) {
            throw new IllegalArgumentException("UserID đã tồn tại!");
        }

        // Tạo đối tượng User
        User user = new User();
        user.setUserId(userId);
        user.setPassword(MD5Util.encrypt(password)); // Mã hóa mật khẩu bằng MD5
        user.setIsActive(true); // Mặc định tài khoản là active
        user.setCreatedDate(LocalDateTime.now());
        user.setCreatedBy("admin");
        user.setUpdatedDate(LocalDateTime.now());
        user.setUpdatedBy("admin");

        // Lưu vào database
        return userReponsitory.save(user);
    }


}
