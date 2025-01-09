package com.example.MaiLinhGroup.reponsitory;

import com.example.MaiLinhGroup.modal.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentReponsitory extends JpaRepository<Department,Long> {

    Optional<Department> findByDepartmentId(String departmentId);

}
