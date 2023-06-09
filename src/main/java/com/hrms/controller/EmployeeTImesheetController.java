package com.hrms.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.entity.EmployeeTimesheet;
import com.hrms.repository.EmployeeTimesheetRepository;
import com.hrms.service.EmployeeTimesheetService;

@RestController
public class EmployeeTImesheetController {
	@Autowired
	EmployeeTimesheetService empService;

	@Autowired
	EmployeeTimesheetRepository emprepo;

	@GetMapping("/employeeTimesheet")
	public String employee(@RequestParam Integer id) {
		EmployeeTimesheet employeeTimesheet = empService.getEmployee(id);

		return employeeTimesheet.toString();
	}

	@GetMapping("/employeesTimesheet")
	public String employees() {
		List<EmployeeTimesheet> employee_EmployeeTimesheets = empService.getAllEmployee();
		return employee_EmployeeTimesheets.toString();
	}

	@PostMapping("/employeeTimesheet")
	public EmployeeTimesheet save(@RequestBody EmployeeTimesheet employeeTimesheet) {
		employeeTimesheet.setCreated_on(new Date());
		return this.empService.saveEmployeeTimesheet(employeeTimesheet);
	}

	@DeleteMapping("/employeeTimesheet")
	public void deleteEmployee(@PathVariable String Id) {

		this.empService.empdeleteByid(Integer.parseInt(Id));
	}


//	@PutMapping("/employeeTimesheet")
//	public EmployeeTimesheet updateEmployeeTimesheet(
//	@RequestBody EmployeeTimesheet employeeTimesheet) {
//	empService.updateEmployeeTimesheet(employeeTimesheet);
//	return employeeTimesheet; 
//	}
}
