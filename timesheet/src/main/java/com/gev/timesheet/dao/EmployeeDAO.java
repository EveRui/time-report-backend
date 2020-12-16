package com.gev.timesheet.dao;

import com.gev.timesheet.domain.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface EmployeeDAO extends MongoRepository<Employee, String> {
    Optional<Employee> findByUserid(String userid);

}
