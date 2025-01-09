package com.example.MaiLinhGroup.Service;

import com.example.MaiLinhGroup.modal.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    User findUserProfileByJwt(String jwt)throws Exception;
}
