package com.dev.timesheet.controller;


import com.dev.timesheet.dao.TimesheetDAO;
import com.dev.timesheet.dao.EmployeeDAO;

import com.dev.timesheet.domain.Employee;
import com.dev.timesheet.domain.Timesheet;
import com.dev.timesheet.dto.Tmp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Api(value="My Rest Endpoint")
@RequestMapping("/timesheet")
public class MyController {

    @Autowired
    TimesheetDAO timesheetDAO;


    @Autowired
    EmployeeDAO employeeDAO;


    @PostMapping("byFirstname")
    @ApiOperation(value = "Find Timesheet by First Name", response = Timesheet.class)
    public Timesheet getCustomerByFirstName(@RequestBody Tmp data) {
        System.out.println("From react: " + data.getFirstname());
        return timesheetDAO.findByFirstname(data.getFirstname()).orElse(null);
    }
     */

    @GetMapping("all")
    @ApiOperation(value = "List all timesheets", response = Iterable.class)
    public List<Timesheet> getAllTimesheet() {
        return timesheetDAO.findAll();
    }

    @GetMapping("getEmployeeByUserid/{userid}")
    @ApiOperation(value = "Find Employee by User Id", response = Employee.class)
    ResponseEntity<?> getEmployeeByUserid(@PathVariable String userid) {
        System.out.println("From react: " + userid);
        Optional<Employee> rst = employeeDAO.findByUserid(userid);
        return rst.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("updateEmployee")
    @ApiOperation(value = "Update Employee by User Id")
    ResponseEntity<Employee> setEmployeeByUserid(@RequestBody Employee employee) {
        System.out.println("From react: update" );
        Employee result = employeeDAO.save(employee);
        return ResponseEntity.ok().body(result);
    }




}
