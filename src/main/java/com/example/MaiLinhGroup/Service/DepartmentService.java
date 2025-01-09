package com.example.MaiLinhGroup.Service;

import com.example.MaiLinhGroup.modal.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();

    Department updateDepartment(Long departmentId, Department department);

    void updateActiveDepartment(Long departmentId, Boolean isactive);

    Department getDepartmentById(String departmentId);
}
