package com.hrms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entity.Employee_MasterData2;

@Repository
public interface EmployeeMasterData2Repository extends JpaRepository<Employee_MasterData2, Integer> {

	

}
