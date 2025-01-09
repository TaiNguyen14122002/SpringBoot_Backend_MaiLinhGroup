package com.example.MaiLinhGroup.Service;

import com.example.MaiLinhGroup.modal.Branch;

import java.util.List;

public interface BranchService {
    List<Branch> getAllBranch();

    Branch updateBranch(String branchId, Branch branch);

    Branch addBranch(Branch branch);

    void updateActiveBranch(Long branchId, Boolean isactive);

    Branch getBranchById(String branchId);
}
