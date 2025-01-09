package com.example.MaiLinhGroup.reponsitory;

import com.example.MaiLinhGroup.modal.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PartnerReponsitory extends JpaRepository<Partner, Long> {

    Optional<Partner> findByPartnerId(String partnerId);
}
