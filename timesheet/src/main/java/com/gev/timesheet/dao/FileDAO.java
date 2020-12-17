package com.gev.timesheet.dao;

import com.gev.timesheet.domain.File;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FileDAO extends MongoRepository<File, String> {
    Optional<File> findByUseridAndName(String userid, String name);
}
