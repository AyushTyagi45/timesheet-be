package com.hrms.service;

import java.util.List;

import com.hrms.entity.Employee_MasterData2;


public interface Employee_MasterData2Service {

	 Employee_MasterData2 getEmployee(int id);

	// List<Employee_MasterData2> getEmployeeByList(String idListSepByComma);

	 Employee_MasterData2 saveEmployeeMaster( Employee_MasterData2 employeemaster  );

	 List<Employee_MasterData2> getAllEmployee();

	void empdeleteByid(int id);

}
