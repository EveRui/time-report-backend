package com.dev.timesheet.dao;

import com.dev.timesheet.domain.PTO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PtoDAO extends MongoRepository<PTO, String> {
    Optional<PTO> findByUseridAndYear(String userid, Integer year);
}
