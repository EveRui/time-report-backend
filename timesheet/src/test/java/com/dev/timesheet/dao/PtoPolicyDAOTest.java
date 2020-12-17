package com.dev.timesheet.dao;

import com.dev.timesheet.TimesheetApplication;

import com.dev.timesheet.domain.PTO;
import com.dev.timesheet.domain.PtoPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {TimesheetApplication.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PtoPolicyDAOTest {
    @Autowired
    private PtoPolicyDAO ptoPolicyDAO;

    @Test
    public void testFindByJobtitleAndYear() {
        PtoPolicy policy = ptoPolicyDAO.findByJobtitleAndYear("SDE",2019).orElse(null);
        Assertions.assertAll(() -> {
            Assertions.assertEquals(3, policy.getFloatingnum());
            //Assertions.assertEquals(5, testdao.findAll().size());
        });
    }
}
