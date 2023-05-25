package com.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.dto.EmployeeMasterDto;
import com.hrms.entity.EmployeeMaster;
import com.hrms.service.EmployeeMasterService;
@RestController
public class EmployeeController {
		
		@Autowired
		EmployeeMasterService employeeMasterService;
		
		@GetMapping("/Test")
		public String getEmployee(){
			return "Fine";
		}
			
			@GetMapping("/employee")
			public String employee(@RequestParam Integer id) {
			EmployeeMaster employeeMasterEntity = employeeMasterService.getEmployee(id);
			
			return employeeMasterEntity.toString();
			}

			@GetMapping("/employees")
			public String employees() {
				List<EmployeeMaster> employeeMasterEntity = employeeMasterService.getAllEmployee();
				return employeeMasterEntity.toString();
			}

			@PostMapping("/employee")
			public String employee(@RequestBody EmployeeMasterDto dto) {
				EmployeeMaster employeeMasterEntity = employeeMasterService.saveEmployeeMaster(dto);

				return employeeMasterEntity.toString();
			}
				
			@PutMapping("/employee")
			public EmployeeMaster updateEmployeeMaster(
		    @RequestBody EmployeeMaster employeeMaster) {
			employeeMasterService.updateEmployeeMaster(employeeMaster);
					return employeeMaster; 
		
		}
	}
