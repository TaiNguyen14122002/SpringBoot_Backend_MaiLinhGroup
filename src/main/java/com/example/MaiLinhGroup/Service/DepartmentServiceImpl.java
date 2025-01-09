package com.example.MaiLinhGroup.Service;

import com.example.MaiLinhGroup.modal.Branch;
import com.example.MaiLinhGroup.modal.Department;
import com.example.MaiLinhGroup.reponsitory.DepartmentReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentReponsitory departmentReponsitory;

    @Override
    public List<Department> findAll() {
        List<Department> branchList = departmentReponsitory.findAll();
        return branchList;
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Optional<Department> optionalDepartment = departmentReponsitory.findById(departmentId);
        if (optionalDepartment.isEmpty()) {
            throw new RuntimeException("Department not found with ID: " + departmentId);
        }

        Department existingDepartment = optionalDepartment.get();

        if (department.getDepartmentName() != null) {
            existingDepartment.setDepartmentName(department.getDepartmentName());
        }
        if (department.getUpdatedBy() != null) {
            existingDepartment.setUpdatedBy(department.getUpdatedBy());
        }
        if (department.getIsActive() != null) {
            existingDepartment.setIsActive(department.getIsActive());
        }
        if (department.getUpdatedBy() != null) {
            existingDepartment.setUpdatedBy(department.getUpdatedBy());
        }
        if (department.getRecId() != null) {
            existingDepartment.setRecId(department.getRecId());
        }

        existingDepartment.setUpdatedDate(LocalDateTime.now());

        return departmentReponsitory.save(existingDepartment);
    }

    @Override
    public void updateActiveDepartment(Long departmentId, Boolean isactive) {
        Department department = departmentReponsitory.findById(departmentId).orElseThrow(() ->
                new RuntimeException("Department not found with ID: " + departmentId));

        department.setIsActive(isactive);
        department.setUpdatedDate(LocalDateTime.now());
        departmentReponsitory.save(department);
    }

    @Override
    public Department getDepartmentById(String departmentId) {
        return departmentReponsitory.findByDepartmentId(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found with ID: " + departmentId));
    }


}
