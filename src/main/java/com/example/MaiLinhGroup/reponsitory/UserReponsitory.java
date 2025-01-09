package com.example.MaiLinhGroup.reponsitory;

import com.example.MaiLinhGroup.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReponsitory extends JpaRepository<User, Long> {
    User findByUserId(String userId);
}
