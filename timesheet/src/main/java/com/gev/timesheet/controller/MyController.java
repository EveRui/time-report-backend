
package com.gev.timesheet.controller;



import com.gev.timesheet.dao.EmployeeDAO;
import com.gev.timesheet.dao.TimesheetDAO;
import com.gev.timesheet.domain.Timesheet;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Api(value="My Rest Endpoint")
@RequestMapping("/timesheet")
public class MyController {

    @Autowired
    TimesheetDAO timesheetDAO;

    @Autowired
    PtoDAO ptoDAO;

    @Autowired
    PtoPolicyDAO ptoPolicyDAO;

    /*
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
    }}
