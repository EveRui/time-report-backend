package com.gev.timesheet.dao;

import com.gev.timesheet.domain.PtoPolicy;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PtoPolicyDAO extends MongoRepository<PtoPolicy, String> {
    Optional<PtoPolicy> findByJobtitleAndYear(String jobtitle, Integer year);
}
