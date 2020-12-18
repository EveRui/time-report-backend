package com.dev.timesheet.controller;

import com.dev.timesheet.dao.PtoDAO;
import com.dev.timesheet.dao.PtoPolicyDAO;
import com.dev.timesheet.dao.TimesheetDAO;
import com.dev.timesheet.domain.PTO;
import com.dev.timesheet.domain.PtoPolicy;
import com.dev.timesheet.domain.Timesheet;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@Api(value="My Rest Endpoint")
@RequestMapping("/timesheet")
public class TimesheetController {

    @Autowired
    TimesheetDAO timesheetDAO;

    @Autowired
    PtoDAO ptoDAO;

    @Autowired
    PtoPolicyDAO ptoPolicyDAO;


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

    @GetMapping("getTimesheetByUseridAndWeekending/{userid}/{weekending}")
    @ApiOperation(value = "Find Timesheet by userid&Year", response = PtoPolicy.class)
    ResponseEntity<?> getTimesheetByUseridAndWeekending(@PathVariable String userid, @PathVariable String weekending) {

        System.out.println("From react: " + userid + "-" + weekending);
        Optional<Timesheet> rst = timesheetDAO.findByUseridAndWeekending(userid,weekending);
        return rst.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("getTimesheetListByUserid/{userid}")
    @ApiOperation(value = "List all timesheets by userid", response = Iterable.class)
    public List<Timesheet> getAllTimesheetByUserid(@PathVariable String userid) {
        List<Timesheet> list = timesheetDAO.findByUserid(userid);

//        Collections.sort(list, new Comparator<Timesheet>(){
//           @SneakyThrows
//           public int compare(Timesheet t1, Timesheet t2){
//               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//               Date d1 = sdf.parse(t1.getWeekending());
//               Date d2 = sdf.parse(t2.getWeekending());
//               return d1.compareTo(d2);
//           }
//        });

        return list;
    }

    @PostMapping("updateTimesheet")
    @ApiOperation(value = "Update Timesheet by User Id")
    ResponseEntity<Timesheet> setTimesheetByUserid(@RequestBody Timesheet timesheet) {
        System.out.println("From react: update timesheet" );
        Timesheet result = timesheetDAO.save(timesheet);
        return ResponseEntity.ok().body(result);
    }

}
