package com.dev.timesheet.dao;


import com.dev.timesheet.TimesheetApplication;
import com.dev.timesheet.domain.PTO;
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
public class PtoDAOTest {
    @Autowired
    private PtoDAO testdao;

    @BeforeAll
    public void init() {
    }

    @Test
    public void testFindByUseridAndWeekending() {
        PTO pto = testdao.findByUseridAndYear("test", 2021).orElse(null);
        Assertions.assertAll(() -> {
            Assertions.assertEquals(3, pto.getFloatingleft());
            //Assertions.assertEquals(5, testdao.findAll().size());
        });
    }
}
