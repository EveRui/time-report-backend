package com.gev.timesheet.dao;

import com.gev.timesheet.domain.PTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface PtoDAO extends MongoRepository<PTO, String> {
    Optional<PTO> findByUseridAndYear(String userid, Integer year);
}
