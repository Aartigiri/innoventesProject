package com.example.innoventesProject.controller;


import com.example.innoventesProject.dto.EmployeeAddressDto;
import com.example.innoventesProject.dto.EmployeeAddressResponse;
import com.example.innoventesProject.dto.EmployeeAddressResponse1;
import com.example.innoventesProject.dto.ResponseObject;
import com.example.innoventesProject.service.EmployeeDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author aarti Giri
 */



@RestController
public class EmployeeDetailsController {

    private static final Logger LOG = LoggerFactory.getLogger(com.example.innoventesProject.controller.EmployeeDetailsController.class);
@Autowired
EmployeeDetailsService employeeDetailsService;
    /**
     * This method is used for inserting data in database.It is a backup api.
     * @param employeeAddressDto
     * @return If employeeaddress exists then returns error saying events already exists else return employeeaddress details.
     */


    @PostMapping(value = "/insert/data")
    public ResponseEntity<ResponseObject<EmployeeAddressResponse>> insertDataR(@RequestBody EmployeeAddressDto employeeAddressDto) {
        LOG.trace(" -->ENTRY-->addressDto() :: {}", employeeAddressDto);
        ResponseObject<EmployeeAddressResponse> userResponseBeaconResponseObject =
                employeeDetailsService.insertData(employeeAddressDto);
        LOG.trace("<--EXIT<--insertPushNotification() :: {}", userResponseBeaconResponseObject);
        return ResponseEntity.ok(userResponseBeaconResponseObject);
    }

    /**
     * This method is used to get list of employeeList for all data.
     */


    @GetMapping(value = "/getAllDataFromDb")
    public ResponseEntity<ResponseObject<EmployeeAddressResponse1>> findAllData() {
        LOG.trace("-->>ENTRY -->> findAllData()");
        ResponseObject<EmployeeAddressResponse1> itemResponseObject = employeeDetailsService.findAllData();
        LOG.trace("<--EXIT<-- findAllData() :: {}", itemResponseObject);
        return ResponseEntity.ok(itemResponseObject);

    }

    /**
     * This method is used for update data in database.It is a backup api.
     * @param employeeAddressDto
     */

    @PutMapping(value = "/updateData")
    public ResponseEntity<ResponseObject<EmployeeAddressResponse>> updateData(@RequestBody EmployeeAddressDto employeeAddressDto) {
        LOG.trace("-->>ENTRY -->> updateData()");
        ResponseObject<EmployeeAddressResponse> userResponseObject = employeeDetailsService.updateData(employeeAddressDto);
        LOG.trace("<--EXIT<-- updateData() :: {}", userResponseObject);
        return ResponseEntity.ok(userResponseObject);
    }

    /**
     * This method is used for delete data in database.It is a backup api.
     * @param employeeaddressId
     */


    @DeleteMapping(value = "/deleteData/{applicationNo}")
    ResponseEntity<ResponseObject<EmployeeAddressResponse>> deleteData(@PathVariable("employeeaddressId") Long employeeaddressId) {
        LOG.trace("-->>ENTRY -->> deleteData() :: {}", employeeaddressId);
        ResponseObject<EmployeeAddressResponse> userResponseObject = employeeDetailsService.deleteData(employeeaddressId);
        LOG.trace("<--EXIT<-- deleteData() :: {}", userResponseObject);
        return ResponseEntity.ok(userResponseObject);
    }

    /**
     * This method is used for update data in database.It is a backup api.
     * @param employeeAddressDto
     */

    @PutMapping(value = "/updateDataAddress")
    public ResponseEntity<ResponseObject<EmployeeAddressResponse>> updateDataAddress(@RequestBody EmployeeAddressDto employeeAddressDto) {
        LOG.trace("-->>ENTRY -->> updateData()");
        ResponseObject<EmployeeAddressResponse> userResponseObject = employeeDetailsService.updateDataAddress(employeeAddressDto);
        LOG.trace("<--EXIT<-- updateData() :: {}", userResponseObject);
        return ResponseEntity.ok(userResponseObject);
    }

    /**
     * This method is used for get data in database  by employee name.It is a backup api.
     * @param employeeName
     */


    @GetMapping(value = "/getAllDataFromRpa/{employeeName}")
    public ResponseEntity<ResponseObject<EmployeeAddressResponse>> findByUsername(@PathVariable("employeeName") String employeeName) {
        LOG.trace("-->>ENTRY -->> findAllData()");
        ResponseObject<EmployeeAddressResponse> itemResponseObject = employeeDetailsService.findByemployeeName(employeeName);
        LOG.trace("<--EXIT<-- findAllData() :: {}", itemResponseObject);
        return ResponseEntity.ok(itemResponseObject);

        //(ResponseEntity<List<ResponseObject<IdentityResponse>>>) ResponseEntity.ok();
    }





}
