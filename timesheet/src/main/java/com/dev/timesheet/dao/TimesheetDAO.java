package com.dev.timesheet.dao;

import com.dev.timesheet.domain.Timesheet;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TimesheetDAO extends MongoRepository<Timesheet, String> {
    Optional<Timesheet> findByUseridAndWeekending(String userid, String weekending);

    List<Timesheet> findByUserid(String userid);

}
