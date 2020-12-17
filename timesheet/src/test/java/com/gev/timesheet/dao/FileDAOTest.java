package com.gev.timesheet.dao;

import com.gev.timesheet.TimesheetApplication;
import com.gev.timesheet.domain.File;
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
public class FileDAOTest {

    @Autowired
    private FileDAO fileDAO;

    @BeforeAll
    public void init() {
    }

    @Test
    public void testFindByUseridAndName() {
        File file = fileDAO.findByUseridAndName("test", "testfile").orElse(null);
        Assertions.assertAll(() -> {
            Assertions.assertEquals("2020-12-15", file.getDate());
            Assertions.assertEquals(2, fileDAO.findAll().size());
        });
    }
}
