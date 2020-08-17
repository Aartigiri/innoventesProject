package com.example.innoventesProject.repository;


import com.example.innoventesProject.entity.Address;

import com.example.innoventesProject.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRead extends CrudRepository<Address,String> {

    Optional<Address> findByaddressId(Long addressId);


}
