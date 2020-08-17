package com.example.innoventesProject.dto;


public class EmployeeAddressResponse {


    private Long employeeAddressId;

    private AddressResponse addressResponse;

    private EmployeeResponse employeeResponse;

    private String addressType;


    public Long getEmployeeAddressId() {
        return employeeAddressId;
    }

    public void setEmployeeAddressId(Long employeeAddressId) {
        this.employeeAddressId = employeeAddressId;
    }

    public AddressResponse getAddressResponse() {
        return addressResponse;
    }

    public void setAddressResponse(AddressResponse addressResponse) {
        this.addressResponse = addressResponse;
    }

    public EmployeeResponse getEmployeeResponse() {
        return employeeResponse;
    }

    public void setEmployeeResponse(EmployeeResponse employeeResponse) {
        this.employeeResponse = employeeResponse;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }
}

