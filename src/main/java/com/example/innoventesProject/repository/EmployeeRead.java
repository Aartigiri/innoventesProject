package com.example.innoventesProject.repository;


import com.example.innoventesProject.entity.Employee;

import com.example.innoventesProject.entity.EmployeeAddress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRead extends CrudRepository<Employee,String> {

    Optional<Employee> findByemployeeId(Long employeeId);

    Optional<Employee> findByemployeeName(String employeeName);
}
