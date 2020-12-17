package com.gev.timesheet.service;

import com.gev.timesheet.dao.EmployeeDAO;
import com.gev.timesheet.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class ProfileService {
    private EmployeeDAO employeeDAO;

    @Autowired
    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Transactional
    public Optional<Employee> getEmployeeByUserid(String userid) {
        return employeeDAO.findByUserid(userid);
    }

    @Transactional
    public Employee setEmployeeByUserid(Employee employee) {
        return employeeDAO.save(employee);
    }




}
