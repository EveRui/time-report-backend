package com.dev.timesheet.controller;

import com.dev.timesheet.dao.EmployeeDAO;
import com.dev.timesheet.domain.Employee;
import com.dev.timesheet.service.ProfileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Api(value="My Rest Endpoint")
@RequestMapping("/timesheet")
public class ProfileController {

    ProfileService profileService;

    @Autowired
    public void setProfileServiceService(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("getEmployeeByUserid/{userid}")
    @ApiOperation(value = "Find Employee by User Id", response = Employee.class)
    ResponseEntity<?> getEmployeeByUserid(@PathVariable String userid) {
        System.out.println("From react get user: " + userid);
        Optional<Employee> rst = profileService.getEmployeeByUserid(userid);
        return rst.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("updateEmployee")
    @ApiOperation(value = "Update or Save Employee by User Id")
    ResponseEntity<Employee> setEmployeeByUserid(@RequestBody Employee employee) {
        System.out.println("From react update user:"+employee.getUserid() );
        Employee result = profileService.setEmployeeByUserid(employee);
        return ResponseEntity.ok().body(result);
    }
}
