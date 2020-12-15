package com.dev.timesheet.dao;

import com.dev.timesheet.domain.Employee;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface EmployeeDAO extends MongoRepository<Employee, String> {
    Optional<Employee> findByUserid(String userid);
}
