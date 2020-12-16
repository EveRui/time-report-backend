package com.gev.timesheet;


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
	@Autowired
	EmployeeDAO employeeDAO;


	@Override
	public void run(String... args) throws Exception {


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
		//employeeDAO
//save a employee
		Address addr = Address.builder().line1("123 Rd").line2("Apt 1").city("SF").state("CA").zipcode("123456").build();
		Emergency emergencies = Emergency.builder().firstname1("fn1").lastname1("ln1").phone1("111-111-1111").firstname2("fn2").lastname2("ln2").phone1("222-222-2222").build();
		employeeDAO.save(Employee.builder().userid("1").phone("123-123-1234").email("123@gmail.com").address(addr).emergency(emergencies).build());

//fetch
		System.out.println("Employee found with findAll():");
		System.out.println("-------------------------------");
		for (Employee employee : employeeDAO.findAll()) {
			System.out.println(employee);


		}
	}
*/
}
