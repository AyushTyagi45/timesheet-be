package com.hrms.service;

import java.util.List;

import com.hrms.entity.EmployeeTimesheet;


public interface EmployeeTimesheetService {

	EmployeeTimesheet getEmployee(int id);

	EmployeeTimesheet saveEmployeeTimesheet(EmployeeTimesheet employeeTimesheet );

	List<EmployeeTimesheet> getAllEmployee();

	void empdeleteByid(int id);

	void updateEmployeeTimesheet(int employeeTimesheetId, EmployeeTimesheet employeeTimesheet);

}
