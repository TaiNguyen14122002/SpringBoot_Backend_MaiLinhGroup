package com.example.MaiLinhGroup.reponsitory;

import com.example.MaiLinhGroup.modal.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BranchReponsitory extends JpaRepository<Branch, Long> {
    // Phương thức tìm recId lớn nhất hiện có
    @Query("SELECT MAX(b.branchId) FROM Branch b")
    Long findMaxBranchId();

    Optional<Branch> findByBranchId(String branchId);
}
