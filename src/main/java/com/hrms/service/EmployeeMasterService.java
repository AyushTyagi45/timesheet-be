package com.hrms.service;

import java.util.List;

import com.hrms.dto.EmployeeMasterDto;
import com.hrms.entity.EmployeeMaster;


public interface EmployeeMasterService {

	public EmployeeMaster getEmployee(int id);

	public List<EmployeeMaster> getEmployeeByList(String idListSepByComma);

	public EmployeeMaster saveEmployeeMaster(EmployeeMasterDto employeeMasterDto);

	public List<EmployeeMaster> getAllEmployee();

	public void EmployeedeleteById(Integer id);

	public void updateEmployeeMaster(EmployeeMaster employeeMaster);

	
}
