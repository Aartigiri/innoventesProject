package com.example.innoventesProject.service;

import com.example.innoventesProject.dto.EmployeeAddressDto;
import com.example.innoventesProject.dto.EmployeeAddressResponse;
import com.example.innoventesProject.dto.EmployeeAddressResponse1;
import com.example.innoventesProject.dto.ResponseObject;

public interface EmployeeDetailsService {

    ResponseObject<EmployeeAddressResponse> insertData(EmployeeAddressDto employeeAddressDto);

    public ResponseObject<EmployeeAddressResponse1> findAllData();

    public ResponseObject<EmployeeAddressResponse> updateData(EmployeeAddressDto employeeAddressDto);


    public ResponseObject<EmployeeAddressResponse> deleteData(Long employeeaddressId);

    public ResponseObject<EmployeeAddressResponse> findByemployeeName(String employeeName);

    public ResponseObject<EmployeeAddressResponse> updateDataAddress(EmployeeAddressDto employeeAddressDto);
}


