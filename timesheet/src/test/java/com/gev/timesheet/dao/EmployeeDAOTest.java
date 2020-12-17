package com.gev.timesheet.dao;


import com.gev.timesheet.TimesheetApplication;
import com.gev.timesheet.domain.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {TimesheetApplication.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EmployeeDAOTest {
    @Autowired
    private EmployeeDAO testdao;

    @BeforeAll
    public void init() {
    }

    @Test
    public void testFindByUserid() {
        Employee employee = testdao.findByUserid("test").orElse(null);
        Assertions.assertAll(() -> {
            Assertions.assertEquals("123@gmail.com", employee.getEmail());

        });
    }
}
