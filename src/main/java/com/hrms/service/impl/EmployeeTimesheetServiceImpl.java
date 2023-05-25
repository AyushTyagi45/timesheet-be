package com.hrms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.entity.EmployeeTimesheet;
import com.hrms.repository.EmployeeTimesheetRepository;
import com.hrms.service.EmployeeTimesheetService;
@Service
public class EmployeeTimesheetServiceImpl implements EmployeeTimesheetService{
	
	@Autowired
	EmployeeTimesheetRepository empRepository ;
		

	@Override
	public EmployeeTimesheet getEmployee(int id) {
	Optional<EmployeeTimesheet> emp = empRepository.findById(id);
	return emp.isEmpty() ? null:emp.get();

	}


	@Override
	public EmployeeTimesheet saveEmployeeTimesheet(EmployeeTimesheet employeeTimesheet) {	
		
    empRepository.save(employeeTimesheet);
    return employeeTimesheet;
	}


	@Override
	public List<EmployeeTimesheet> getAllEmployee() {
		
			return empRepository.findAll();
	}


	@Override
	public void empdeleteByid(int id) {
		
		 empRepository.deleteById(id);
		
	}
	
	@Override
	public void updateEmployeeTimesheet(EmployeeTimesheet employeeTimesheet) {
		EmployeeTimesheet employeeTimesheetFromDb = empRepository.findById(employeeTimesheet.getEmp_id()).get();
		System.out.println(employeeTimesheetFromDb.toString());
	    employeeTimesheetFromDb.setEmp_id(employeeTimesheet.getEmp_id());
		employeeTimesheetFromDb.setEmail_id(employeeTimesheet.getEmail_id());
		employeeTimesheetFromDb.setEmployee_name(employeeTimesheet.getEmployee_name());
		employeeTimesheetFromDb.setDescription(employeeTimesheet.getDescription());
		employeeTimesheetFromDb.setCreated_on(employeeTimesheet.getCreated_on());
		empRepository.save(employeeTimesheetFromDb);
	}

}
	
	
	



