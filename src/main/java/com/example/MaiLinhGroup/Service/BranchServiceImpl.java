package com.example.MaiLinhGroup.Service;

import com.example.MaiLinhGroup.modal.Branch;
import com.example.MaiLinhGroup.reponsitory.BranchReponsitory;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BranchServiceImpl implements BranchService{

    @Autowired
    private BranchReponsitory branchReponsitory;

    @Override
    public List<Branch> getAllBranch() {
        List<Branch> branchList = branchReponsitory.findAll();
        return branchList;
    }

    @Override
    public Branch updateBranch(String branchId, Branch branch) {
        Optional<Branch> optionalBranch = branchReponsitory.findByBranchId(branchId);
        if (optionalBranch.isEmpty()) {
            throw new RuntimeException("Branch not found with ID: " + branchId);
        }

        Branch existingBranch = optionalBranch.get();

        if (branch.getBranchName() != null) {
            existingBranch.setBranchName(branch.getBranchName());
        }
        if (branch.getZoneId() != null) {
            existingBranch.setZoneId(branch.getZoneId());
        }
        if (branch.getIsActive() != null) {
            existingBranch.setIsActive(branch.getIsActive());
        }
        if (branch.getUpdatedBy() != null) {
            existingBranch.setUpdatedBy(branch.getUpdatedBy());
        }
        if (branch.getRecId() != null) {
            existingBranch.setRecId(branch.getRecId());
        }

        existingBranch.setUpdatedDate(LocalDateTime.now());

        return branchReponsitory.save(existingBranch);
    }

    // Phương thức tạo recId tự động
    private Long getNextBranchId() {
        // Tìm recId cao nhất hiện có trong cơ sở dữ liệu
        Long maxBranchId = branchReponsitory.findMaxBranchId();

        // Nếu không có dữ liệu, trả về 1, nếu có thì trả về maxRecId + 1
        if (maxBranchId == null) {
            return 1L;
        } else {
            return maxBranchId + 1;
        }
    }

    @Override
    public Branch addBranch(Branch branch) {

        // Lấy recId tự động và đảm bảo không bị trùng
        Long generatedBranchId = getNextBranchId();
        branch.setBranchId(generatedBranchId.toString());

        // Thiết lập thông tin mặc định
        branch.setCreatedDate(LocalDateTime.now());
        branch.setUpdatedDate(LocalDateTime.now());
        branch.setCreatedBy("admin");
        branch.setUpdatedBy("admin");

        // Lưu branch để Hibernate tự động gán recId
        System.out.println("Add Brancccccch: " + branch.getRecId());
//        branch = branchReponsitory.save(branch);

        // Kiểm tra và gán branchId sau khi recId được gán
        if (branch.getBranchId() == null && branch.getRecId() != null) {
            branch.setBranchId("CN" + String.format("%04d", branch.getRecId()));
            System.out.println("Add Branchhhh: " + branch.getBranchId());
            branch = branchReponsitory.save(branch); // Cập nhật lại branchId trong cơ sở dữ liệu
        }

        // In thông tin đã được cập nhật
        System.out.println("Add Branch: " + branch.getBranchId());

        return branch;
    }


    @Override
    public void updateActiveBranch(Long branchId, Boolean isactive) {
        Branch branch = branchReponsitory.findById(branchId).orElseThrow(() ->
                new RuntimeException("Branch not found with ID: " + branchId));

        branch.setIsActive(isactive);
        branchReponsitory.save(branch);
    }

    @Override
    public Branch getBranchById(String branchId) {
        return branchReponsitory.findByBranchId(branchId)
                .orElseThrow(() -> new RuntimeException("Branch not found with ID: " + branchId));
    }


}
