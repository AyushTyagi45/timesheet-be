package com.hrms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.entity.Employee_MasterData2;
import com.hrms.repository.EmployeeMasterData2Repository;
import com.hrms.service.Employee_MasterData2Service;
@Service
public class EmployeeMasterData2Impl implements Employee_MasterData2Service{
	

	@Autowired
	EmployeeMasterData2Repository empMastereRepo ;
		

	@Override
	public Employee_MasterData2 getEmployee(int id) {
	Optional<Employee_MasterData2> emp = empMastereRepo.findById(id);
	return emp.isEmpty() ? null:emp.get();

	}

	@Override
	public Employee_MasterData2 saveEmployeeMaster(Employee_MasterData2 employeemaster) {
		empMastereRepo.save(employeemaster);
		
		return employeemaster;
	}

	@Override
	public List<Employee_MasterData2> getAllEmployee() {
		
		return empMastereRepo.findAll();
	}


	@Override
	public void empdeleteByid(int id) {
		
	 empMastereRepo.deleteById(id);
	}


}
