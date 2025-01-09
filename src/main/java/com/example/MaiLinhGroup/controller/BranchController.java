package com.example.MaiLinhGroup.controller;

import com.example.MaiLinhGroup.Service.BranchService;
import com.example.MaiLinhGroup.modal.Branch;
import com.example.MaiLinhGroup.modal.User;
import com.example.MaiLinhGroup.reponsitory.BranchReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branch")
public class BranchController {

    @Autowired
    private BranchReponsitory branchReponsitory;

    @Autowired
    private BranchService branchService;

    @GetMapping("/show")
    public List<Branch> getBranch (){
        List<Branch> branch = branchService.getAllBranch();
        System.out.println("Users: " + branch);
        return branchService.getAllBranch();
    }

    @PostMapping("/addBranch")
    public ResponseEntity<Branch> addBranch(@RequestBody Branch branch){
        Branch newBranch = branchService.addBranch(branch);
        return ResponseEntity.ok(newBranch);
    }

    @PutMapping("/{BranchId}")
    public ResponseEntity<Branch> updateBranch(@PathVariable String BranchId, @RequestBody Branch branch) {
        Branch updatedBranch = branchService.updateBranch(BranchId, branch);
        return ResponseEntity.ok(updatedBranch);
    }

    @PutMapping("/{BranchId}/Deleted")
    public ResponseEntity<String> deleteBranch(@PathVariable Long BranchId, @RequestParam boolean isActive) {
        try {
            branchService.updateActiveBranch(BranchId, isActive);
            return ResponseEntity.ok("Branch active status updated successfully.");
        }catch(RuntimeException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/{branchId}")
    public Branch getBranchByBranchId(@PathVariable String branchId) {

        return branchService.getBranchById(branchId);
    }


}
