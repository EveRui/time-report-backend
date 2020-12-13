package com.dev.timesheet.controller;

import com.dev.timesheet.dao.TimesheetDAO;
import com.dev.timesheet.domain.Timesheet;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value="My Rest Endpoint")
@RequestMapping("/timesheet")
public class MyController {

    @Autowired
    TimesheetDAO timesheetDAO;

//    @PostMapping("byFirstname")
//    @ApiOperation(value = "Find Timesheet by First Name",response = Timesheet.class)
//    public Timesheet getCustomerByFirstName(@RequestBody MyRequest request) {
//        return timesheetDAO.findByFirstname(request.getFirstname()).orElse(null);
//    }

    @GetMapping("all")
    @ApiOperation(value = "List all Customer", response = Iterable.class)
    public List<Timesheet> getAllCustomer() {
        return timesheetDAO.findAll();
    }
}
