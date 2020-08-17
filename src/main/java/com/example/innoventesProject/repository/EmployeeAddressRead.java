package com.example.innoventesProject.repository;


import com.example.innoventesProject.entity.EmployeeAddress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeAddressRead  extends CrudRepository<EmployeeAddress,String> {

    Optional<EmployeeAddress> findByemployeeAddressId(Long employeeAddress);


}
