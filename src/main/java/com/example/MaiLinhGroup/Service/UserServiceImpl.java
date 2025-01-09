package com.example.MaiLinhGroup.Service;

import com.example.MaiLinhGroup.config.JwtProvider;
import com.example.MaiLinhGroup.modal.User;
import com.example.MaiLinhGroup.reponsitory.UserReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
