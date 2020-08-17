package com.example.innoventesProject.entity;

import javax.persistence.*;

@Entity(name = "employeeAddress_details")
public class EmployeeAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employeeAddressId")
    private Long employeeAddressId;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="address_id")
    private Address address;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="employee_id")
    private Employee employee;


    @Column(name = "addressType")
    private String addressType;

    public Long getEmployeeAddressId() {
        return employeeAddressId;
    }

    public void setEmployeeAddressId(Long employeeAddressId) {
        this.employeeAddressId = employeeAddressId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    @Override
    public String toString() {
        return "EmployeeAddress{" +
                "employeeAddressId=" + employeeAddressId +
                ", address=" + address +
                ", employee=" + employee +
                ", addressType='" + addressType + '\'' +
                '}';
    }
}
