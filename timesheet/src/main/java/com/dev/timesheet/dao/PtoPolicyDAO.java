package com.dev.timesheet.dao;

import com.dev.timesheet.domain.PtoPolicy;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PtoPolicyDAO extends MongoRepository<PtoPolicy, String> {
    Optional<PtoPolicy> findByJobtitleAndYear(String jobtitle, Integer year);
}
