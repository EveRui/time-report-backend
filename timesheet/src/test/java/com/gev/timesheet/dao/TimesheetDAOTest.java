package com.gev.timesheet.dao;

import com.gev.timesheet.TimesheetApplication;
import com.gev.timesheet.domain.Timesheet;
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
public class TimesheetDAOTest {
    @Autowired
    private TimesheetDAO testdao;

    @BeforeAll
    public void init() {
        //MockitoAnnotations.initMocks(this);
        //Mockito.when(personDAO.getCurrentSession()).thenReturn(null);
        //Mockito.when(personDAO.getCurrentSession()).thenReturn(null);
    }

    @Test
    public void testFindByUseridAndWeekending() {
        Timesheet sheet = testdao.findByUseridAndWeekending("base", "2020-12-12").orElse(null);
        Assertions.assertAll(() -> {
            Assertions.assertEquals(48, sheet.getTotalcompensatedhours());
            Assertions.assertEquals(true, testdao.findAll().size() > 0);
        });
    }

}
