package com.hrms.controller;

import com.hrms.dto.EmployeeMasterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.dto.LoginDto;
import com.hrms.entity.EmployeeMaster;
import com.hrms.service.EmployeeMasterService;

import java.util.Date;
import java.util.List;


@RestController
public class LoginController {
	
	
	@Autowired
	EmployeeMasterService eser;
	
	
	@GetMapping("")
	public String home () {
		return "welcome home";
	}

	@GetMapping("test")
	public String test () {
		return "test";
	}
//	@PostMapping("/login")
//	public LoginResponse login(@RequestBody LoginDto loginDto) {
//		LoginResponse response = new LoginResponse();
//		
//		EmployeeMaster employeeMasterEntity = eMasterSerice.getEmployee(Integer.parseInt(loginDto.getId()));
//		if(employeeMasterEntity.getPassword().equals(loginDto.getPassword()) ) {
//			response.setCode(200);
//			response.setMessage("success");
//			response.setData(employeeMasterEntity);
//		} else {
//			response.setCode(401);
//			response.setMessage("unauthorized");
//		}
//		return response;
//	}
	
//	@PostMapping("/login")
//	public String login(@RequestBody LoginDto loginDto) {
//
//	EmployeeMaster employeeMasterEntity = eser.getEmployee(Integer.parseInt(loginDto.getId()));
//	employeeMasterEntity.setPassword("12345");
//		if(employeeMasterEntity.getPassword().equals("12345")) {
//			response.setCode(SuccessEnum.SUCCESS_LOGIN.getCode());
//			response.setMessage(SuccessEnum.SUCCESS_LOGIN.getMessage());
//			response.setData(employeeMasterEntity);
//		} else {
//			response.setCode(ExceptionEnum.INVALID_SESSION.getErrorCode());
//			response.setMessage(ExceptionEnum.INVALID_SESSION.getMessage());
//		}
//		return response;
//	}
	
	@GetMapping("/get_employee")
	public String employee(@RequestParam Integer id) {
	EmployeeMaster employeeMasterEntity = eser.getEmployee(id);
	
	return employeeMasterEntity.toString();
	}

	@GetMapping("/get_employees")
	public String employees() {
		List<EmployeeMaster> employeeMasterEntity = eser.getAllEmployee();
		return employeeMasterEntity.toString();
	}

	@PostMapping("/save_employee")
	public String employee(@RequestBody EmployeeMasterDto dto) {
		EmployeeMaster employeeMasterEntity = eser.saveEmployeeMaster(dto);

		return employeeMasterEntity.toString();
	}

}
