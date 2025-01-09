package com.example.MaiLinhGroup.Service;

import com.example.MaiLinhGroup.modal.User;
import com.example.MaiLinhGroup.reponsitory.UserReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomeUserDetailsImpl implements UserDetailsService {

    @Autowired
    private UserReponsitory userReponsitory;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userReponsitory.findByUserId(username);

        if(user == null){
            throw new UsernameNotFoundException("User not found with email" + username);
        }
        List<GrantedAuthority> authorities = new ArrayList<>();

        return new org.springframework.security.core.userdetails.User(user.getUserId(),
                user.getPassword(), authorities);
    }
}
