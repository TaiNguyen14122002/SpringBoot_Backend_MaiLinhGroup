package com.example.MaiLinhGroup.reponsitory;

import com.example.MaiLinhGroup.modal.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message, Long> {
    Page<Message> findAll(Pageable pageable);

    Optional<Message> findBySmsId(String smsId);
}
