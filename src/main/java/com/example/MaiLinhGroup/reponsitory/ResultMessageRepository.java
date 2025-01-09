package com.example.MaiLinhGroup.reponsitory;

import com.example.MaiLinhGroup.modal.ResultMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResultMessageRepository extends JpaRepository<ResultMessage, Long> {

    Page<ResultMessage> findAll (Pageable pageable);

    Optional<ResultMessage> findResultMessagesBySmsId(String smsId);
}
