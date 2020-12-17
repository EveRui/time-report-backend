package com.dev.timesheet.controller;

import com.dev.timesheet.dao.PtoDAO;
import com.dev.timesheet.dao.PtoPolicyDAO;
import com.dev.timesheet.dao.TimesheetDAO;
import com.dev.timesheet.domain.PTO;
import com.dev.timesheet.domain.PtoPolicy;
import com.dev.timesheet.domain.Timesheet;
import com.dev.timesheet.dto.DTO;
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
    }


}
