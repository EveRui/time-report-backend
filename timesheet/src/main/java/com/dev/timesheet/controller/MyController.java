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

import java.util.List;
import java.util.Optional;

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

    @GetMapping("getPtoByUseridAndYear/{userid}/year/{year}")
    @ApiOperation(value = "Find PTO by Userid&Year", response = PTO.class)
    ResponseEntity<?> getPtoByUseridAndYear(@PathVariable String userid, @PathVariable String year) {

        System.out.println("From react: " + userid + "-" + year);
        Optional<PTO> rst = ptoDAO.findByUseridAndYear(userid, Integer.parseInt(year));
        return rst.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("updatePTO")
    @ApiOperation(value = "Update PTO by User Id")
    ResponseEntity<PTO> setDtoByUserid(@RequestBody PTO pto) {
        System.out.println("From react: update" );
        PTO result = ptoDAO.save(pto);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("getPtoPolicyByJobtitleAndYear/{jobtitle}/year/{year}")
    @ApiOperation(value = "Find PtoPolicy by Jobtitle&Year", response = PtoPolicy.class)
    ResponseEntity<?> getPtoPolicyByJobtitleAndYear(@PathVariable String jobtitle, @PathVariable String year) {

        System.out.println("From react: " + jobtitle + "-" + year);
        Optional<PtoPolicy> rst = ptoPolicyDAO.findByJobtitleAndYear(jobtitle, Integer.parseInt(year));
        return rst.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
