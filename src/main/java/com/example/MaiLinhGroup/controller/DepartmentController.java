package com.example.MaiLinhGroup.controller;

import com.example.MaiLinhGroup.Service.DepartmentService;
import com.example.MaiLinhGroup.modal.Branch;
import com.example.MaiLinhGroup.modal.Department;
import com.example.MaiLinhGroup.reponsitory.DepartmentReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    @Autowired
    private DepartmentReponsitory departmentReponsitory;

    @Autowired
    private DepartmentService departmentService;


    @GetMapping("/show")
    public List<Department> getBranch (){
        List<Department> branch = departmentReponsitory.findAll();
        System.out.println("Users: " + branch);
        return departmentReponsitory.findAll();
    }

//    @PostMapping("/adđepảtment")
//    public ResponseEntity<Branch> addBranch(@RequestBody Branch branch){
//        Branch newBranch = branchService.addBranch(branch);
//        return ResponseEntity.ok(newBranch);
//    }

    @PutMapping("/{departmentId}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long departmentId, @RequestBody Department department) {
        Department updatedDepartment = departmentService.updateDepartment(departmentId, department);
        return ResponseEntity.ok(updatedDepartment);
    }

    @PutMapping("/{DepartmentId}/Deleted")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long DepartmentId, @RequestParam boolean isActive) {
        try {
            departmentService.updateActiveDepartment(DepartmentId, isActive);
            return ResponseEntity.ok("Department active status updated successfully.");
        }catch(RuntimeException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/{departmentId}")
    public Department getDepartmentByDepartmentId(@PathVariable String departmentId) {
        return departmentService.getDepartmentById(departmentId);
    }


}
