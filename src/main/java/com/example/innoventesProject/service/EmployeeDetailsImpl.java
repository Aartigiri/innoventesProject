package com.example.innoventesProject.service;

import com.example.innoventesProject.dto.*;
import com.example.innoventesProject.entity.Address;
import com.example.innoventesProject.entity.Employee;
import com.example.innoventesProject.entity.EmployeeAddress;
import com.example.innoventesProject.repository.AddressRead;
import com.example.innoventesProject.repository.EmployeeAddressRead;
import com.example.innoventesProject.repository.EmployeeRead;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeDetailsImpl implements EmployeeDetailsService {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeDetailsImpl.class);


    @Autowired
    EmployeeAddressRead employeeAddressRead;

    @Autowired
    AddressRead addressRead;

    @Autowired
    EmployeeRead employeeRead;

    @Override
    public ResponseObject<EmployeeAddressResponse> insertData(EmployeeAddressDto employeeAddressDto){
        LOG.trace(" -->ENTRY-->CreateUser() :: {}", employeeAddressDto);
        EmployeeAddressResponse employeeAddressResponse=new EmployeeAddressResponse();
        Optional<EmployeeAddress> employeeAddress = Optional.empty();
        try{
            employeeAddress = employeeAddressRead.findByemployeeAddressId(employeeAddressDto.getEmployeeAddressId());
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        if (!employeeAddress.isPresent()){
           // employeeAddress1.setEmployeeAddressId();
            EmployeeAddress employeeAddress1=new EmployeeAddress();
            Employee employee=new Employee();
            employee.setEmployeeName(employeeAddressDto.getEmployeeDto().getEmployeeName());
            employee.setDob(employeeAddressDto.getEmployeeDto().getDob());
            employeeAddress1.setEmployee(employee);
            Address address=new Address();
            address.setAddrLineOne(employeeAddressDto.getAddressDto().getAddrLineOne());
            address.setCity(employeeAddressDto.getAddressDto().getCity());
            employeeAddress1.setAddress(address);
            employeeAddress1.setAddressType(employeeAddressDto.getAddressType());
            addressRead.save(address);
            employeeRead.save(employee);
            employeeAddressRead.save(employeeAddress1);


            employeeAddressResponse.setAddressType(employeeAddress1.getAddressType());

        }

        return ResponseObject.success(employeeAddressResponse);
    }

    @Override
    public ResponseObject<EmployeeAddressResponse1> findAllData() {

        Iterable<EmployeeAddress> entityOptional = null;
        List<EmployeeAddressResponse> employeeAddressResponse1=new ArrayList<>();

        EmployeeAddressResponse1 employeeAddressResponse11=new EmployeeAddressResponse1();

        try{
            entityOptional= employeeAddressRead.findAll();
        }
        catch (Exception ex){
            ex.getMessage();
        }
        entityOptional.forEach(eventEntity -> {
            EmployeeAddressResponse employeeAddressResponse=new EmployeeAddressResponse();
            employeeAddressResponse.setAddressType(eventEntity.getAddressType());
            EmployeeResponse employeeResponse=new EmployeeResponse();
            AddressResponse addressResponse=new AddressResponse();
            employeeAddressResponse.setEmployeeAddressId(eventEntity.getEmployeeAddressId());
            employeeResponse.setEmployeeName(eventEntity.getEmployee().getEmployeeName());
            employeeResponse.setEmployeeId(eventEntity.getEmployee().getEmployeeId());
            addressResponse.setAddrLineOne(eventEntity.getAddress().getAddrLineOne());
            addressResponse.setCity(eventEntity.getAddress().getCity());
            addressResponse.setAddressId(eventEntity.getAddress().getAddressId());
            employeeAddressResponse.setAddressResponse(addressResponse);
            employeeAddressResponse.setEmployeeResponse(employeeResponse);
            employeeAddressResponse1.add(employeeAddressResponse);

        });
        employeeAddressResponse11.setEmployeeAddressResponse( employeeAddressResponse1);

        return ResponseObject.success(employeeAddressResponse11);

    }


    @Override
  public ResponseObject<EmployeeAddressResponse> updateData(EmployeeAddressDto employeeAddressDto){
        EmployeeAddressResponse employeeAddressResponse11=new EmployeeAddressResponse();
        EmployeeAddress employeeAddress1=new EmployeeAddress();
        Address address1=new Address();
        Employee employee1=new Employee();
        Optional<EmployeeAddress>  employeeAddress=Optional.empty();
        Optional<Address> address=Optional.empty();
        Optional<Employee> employee=Optional.empty();
        try {
            employeeAddress=employeeAddressRead.findByemployeeAddressId(employeeAddressDto.getEmployeeAddressId());
            address=  addressRead.findByaddressId(employeeAddressDto.getAddressDto().getAddressId());
            employee = employeeRead.findByemployeeId(employeeAddressDto.getEmployeeDto().getEmployeeId());
        }
      catch (Exception ex){
            ex.printStackTrace();
      }
        employeeAddress1= employeeAddress.get();
        address1=address.get();
        employee1= employee.get();

        employeeAddress1.setAddressType(employeeAddressDto.getAddressType());
        address1.setAddrLineOne(employeeAddressDto.getAddressDto().getAddrLineOne());
        address1.setCity(employeeAddressDto.getAddressDto().getCity());

        employee1.setDob(employeeAddressDto.getEmployeeDto().getDob());
        employee1.setEmployeeName(employeeAddressDto.getEmployeeDto().getEmployeeName());
        addressRead.save(address1);
        employeeRead.save(employee1);
        employeeAddressRead.save(employeeAddress1);

        return ResponseObject.success(employeeAddressResponse11);
    }

    @Override
    public ResponseObject<EmployeeAddressResponse> deleteData(Long employeeaddressId){
        LOG.trace("-->>ENTRY>> deleteData() :: {}", employeeaddressId);
        EmployeeAddressResponse employeeAddressResponse=new EmployeeAddressResponse();
        Optional<EmployeeAddress>  employeeAddress=Optional.empty();
        Optional<Address> address=Optional.empty();
        Optional<Employee> employee=Optional.empty();
        try {
            employeeAddress=employeeAddressRead.findByemployeeAddressId(employeeaddressId);
            address=  addressRead.findByaddressId(employeeAddress.get().getAddress().getAddressId());
            employee = employeeRead.findByemployeeId(employeeAddress.get().getEmployee().getEmployeeId());
        }
        catch (Exception ex){
            ex.printStackTrace();
        }


        Address address11=address.get();
        addressRead.delete(address11);

        Employee employee1=employee.get();
        employeeRead.delete(employee1);


        EmployeeAddress employeeAddress11=employeeAddress.get();
        employeeAddressRead.delete(employeeAddress11);

        return ResponseObject.success(employeeAddressResponse);
    }

    @Override
    public ResponseObject<EmployeeAddressResponse> findByemployeeName(String employeeName){
        EmployeeAddressResponse employeeAddressResponse=new EmployeeAddressResponse();
        Optional<Employee> employee=Optional.empty();
        Optional<Address> address=Optional.empty();
        Optional<EmployeeAddress>  employeeAddress=Optional.empty();
        try {

            employee = employeeRead.findByemployeeName(employeeName);
            employeeAddress=employeeAddressRead.findByemployeeAddressId(employee.get().getEmployeeId());
            address= addressRead.findByaddressId(employeeAddress.get().getAddress().getAddressId());


        }
        catch (Exception ex){
            ex.printStackTrace();
        }
   if (employee.isPresent()){
       EmployeeResponse employeeResponse=new EmployeeResponse();
       AddressResponse addressResponse=new AddressResponse();
       employeeResponse.setEmployeeName(employee.get().getEmployeeName());
       employeeResponse.setEmployeeId(employee.get().getEmployeeId());


       employeeAddressResponse.setAddressResponse(addressResponse);
       employeeAddressResponse.setEmployeeResponse(employeeResponse);

   }
        return ResponseObject.success(employeeAddressResponse);

    }

    @Override
    public ResponseObject<EmployeeAddressResponse> updateDataAddress(EmployeeAddressDto employeeAddressDto){
        EmployeeAddressResponse employeeAddressResponse11=new EmployeeAddressResponse();
        EmployeeAddress employeeAddress1=new EmployeeAddress();
        Address address1=new Address();
        Employee employee1=new Employee();
        Optional<EmployeeAddress>  employeeAddress=Optional.empty();
        Optional<Address> address=Optional.empty();
        Optional<Employee> employee=Optional.empty();
        try {
            employeeAddress=employeeAddressRead.findByemployeeAddressId(employeeAddressDto.getEmployeeAddressId());
            address=  addressRead.findByaddressId(employeeAddressDto.getAddressDto().getAddressId());

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        employeeAddress1= employeeAddress.get();
        address1=address.get();

        address1.setAddrLineOne(employeeAddressDto.getAddressDto().getAddrLineOne());
        address1.setCity(employeeAddressDto.getAddressDto().getCity());
        employeeAddress1.setAddressType(employeeAddressDto.getAddressType());
        addressRead.save(address1);
        employeeAddressRead.save(employeeAddress1);

        return ResponseObject.success(employeeAddressResponse11);
    }

}


