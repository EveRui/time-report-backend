package com.gev.timesheet.controller;

import com.gev.timesheet.dao.PtoDAO;
import com.gev.timesheet.dao.PtoPolicyDAO;
import com.gev.timesheet.dao.TimesheetDAO;
import com.gev.timesheet.domain.PTO;
import com.gev.timesheet.domain.PtoPolicy;
import com.gev.timesheet.domain.Timesheet;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Api(value="Summary Rest Endpoint")
@RequestMapping("/timesheet")
public class SummaryController {

    @Autowired
    TimesheetDAO timesheetDAO;

    @Autowired
    PtoDAO ptoDAO;

    @Autowired
    PtoPolicyDAO ptoPolicyDAO;


    @GetMapping("summary/Pto/{userid}/{year}")
    @ApiOperation(value = "Find PTO by Userid&Year", response = PTO.class)
    ResponseEntity<?> getPtoByUseridAndYear(@PathVariable String userid, @PathVariable String year) {

        System.out.println("From react: " + userid + "-" + year);
        Optional<PTO> rst = ptoDAO.findByUseridAndYear(userid, Integer.parseInt(year));
        return rst.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("summary/updatePto")
    @ApiOperation(value = "Update PTO by User Id")
    ResponseEntity<PTO> setDtoByUserid(@RequestBody PTO pto) {
        System.out.println("From react: update" );
        PTO result = ptoDAO.save(pto);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("summary/PtoPolicy/{jobtitle}/{year}")
    @ApiOperation(value = "Find PtoPolicy by Jobtitle&Year", response = PtoPolicy.class)
    ResponseEntity<?> getPtoPolicyByJobtitleAndYear(@PathVariable String jobtitle, @PathVariable String year) {

        System.out.println("From react: " + jobtitle + "-" + year);
        Optional<PtoPolicy> rst = ptoPolicyDAO.findByJobtitleAndYear(jobtitle, Integer.parseInt(year));
        return rst.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("summary/Timesheet/{userid}/{weekending}")
    @ApiOperation(value = "Find Timesheet by userid&Year", response = Timesheet.class)
    ResponseEntity<?> getTimesheetByUseridAndWeekending(@PathVariable String userid, @PathVariable String weekending) {

        System.out.println("From react: " + userid + "-" + weekending);
        Optional<Timesheet> rst = timesheetDAO.findByUseridAndWeekending(userid,weekending);
        return rst.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("summary/TimesheetList/{userid}")
    @ApiOperation(value = "List all timesheets by userid", response = Iterable.class)
    public List<Timesheet> getAllTimesheetByUserid(@PathVariable String userid) {
        List<Timesheet> list = timesheetDAO.findByUserid(userid);

        return list;
    }

    @PostMapping("summary/updateTimesheet")
    @ApiOperation(value = "Update Timesheet by User Id")
    ResponseEntity<Timesheet> setTimesheetByUserid(@RequestBody Timesheet timesheet) {
        System.out.println("From react: update timesheet" );
        Timesheet result = timesheetDAO.save(timesheet);
        return ResponseEntity.ok().body(result);
    }

}
