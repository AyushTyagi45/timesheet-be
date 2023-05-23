package com.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entity.EmployeeTimesheet;

@Repository
public interface EmployeeTimesheetRepository  extends JpaRepository<EmployeeTimesheet, Integer> {

	

}
