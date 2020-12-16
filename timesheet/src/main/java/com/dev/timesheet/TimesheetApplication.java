package com.dev.timesheet;

import com.dev.timesheet.dao.TimesheetDAO;
import com.dev.timesheet.domain.Timesheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TimesheetApplication {
//public class TimesheetApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(TimesheetApplication.class, args);
	}
/*
	@Autowired
	TimesheetDAO timesheetDAO;

	@Override
	public void run(String... args) throws Exception {

		//timesheetDAO.deleteAll();

		// save a couple of timesheets
		//timesheetDAO.save(Timesheet.builder().firstname("Alice").lastname("Smith").build());
		//timesheetDAO.save(Timesheet.builder().firstname("Bob").lastname("Smith").build());
		Timesheet sheet = timesheetDAO.findByUseridAndWeekending("base", "2020-12-12").orElse(null);
		System.out.println("Timesheet foundby:" + sheet.getApproval());

		// fetch all customers
		System.out.println("Timesheets found with findAll():");
		for (Timesheet timesheet : timesheetDAO.findAll()) {
			System.out.println(timesheet);
		}
	}
*/
}
