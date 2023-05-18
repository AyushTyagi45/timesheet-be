package com.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.dto.EmployeeMasterDto;
import com.hrms.entity.EmployeeMaster;
import com.hrms.entity.Employee_MasterData2;
import com.hrms.service.Employee_MasterData2Service;

@RestController
public class EmpoyeeMasterData2Controller {
	@Autowired 
	Employee_MasterData2Service empService;
	
	@GetMapping("/employeemaster2")
	public String home () {
		return "welcome home";
		
	}
	@GetMapping("/Person")
	public String employee(@RequestParam Integer id) {
	Employee_MasterData2 employee_MasterData2 = empService.getEmployee(id);
	
	return employee_MasterData2.toString();
	}

	@GetMapping("/Persons")
	public String employees() {
		List<Employee_MasterData2> employee_MasterData2Entity = empService.getAllEmployee();
		return employee_MasterData2Entity.toString();
	}

	@PostMapping("/SavePersons")
	public Employee_MasterData2 employee(@RequestBody Employee_MasterData2 dto) {
		

		return this.empService.saveEmployeeMaster(dto);
	}

}
