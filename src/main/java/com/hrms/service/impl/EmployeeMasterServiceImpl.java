package com.hrms.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrms.dto.EmployeeMasterDto;
import com.hrms.entity.EmployeeMaster;
import com.hrms.repository.EmployeeMasterRepository;
import com.hrms.service.EmployeeMasterService;

 
@Service
public class EmployeeMasterServiceImpl implements EmployeeMasterService {

	@Autowired
	private EmployeeMasterRepository eRepo;

	@Override
	public EmployeeMaster getEmployee(int id) {
		Optional<EmployeeMaster> EmployeeList = this.eRepo.findById(id);
		return ! EmployeeList.isPresent() ? null : EmployeeList.get();
	}

	@Override
	public List<EmployeeMaster> getEmployeeByList(String idListSepByComma) {
		List<Integer> listInt = Arrays.asList(idListSepByComma.split(",")).stream().map(e -> Integer.parseInt(e))
				.collect(Collectors.toList());
		return eRepo.findAllByIdIn(listInt);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public EmployeeMaster saveEmployeeMaster(EmployeeMasterDto req) {
		Date todayDate = new Date();
		EmployeeMaster emp1 = new EmployeeMaster();
		if (req.getEmail_id() != null && req.getFirst_Name() != null && req.getLast_Name() != null) {
			//EmployeeMaster eM = new EmployeeMaster();
			emp1.setActive(req.getActive());
			emp1.setRole(req.getRole());
			emp1.setType(req.getType());
			emp1.setCreated_on(todayDate);
			emp1.setUpdated_on(todayDate);
			emp1.setPassword(req.getPassword());
			emp1.setEmail_id(req.getEmail_id());
			emp1.setFirst_Name(req.getFirst_Name());
			emp1.setLast_Name(req.getLast_Name());
			return this.eRepo.save(emp1);
			
		}
		else {
			return null;
		}
		}

	@Override
	public List<EmployeeMaster> getAllEmployee() {
		return eRepo.findAll();
	}

	@Override
	public void EmployeedeleteById(Integer id) {
		eRepo.deleteById(id);
	}

	@Override
	public void updateEmployeeMaster(EmployeeMaster employeeMaster1) {
	EmployeeMaster employeeMasterFromDb = eRepo.findById(employeeMaster1.getId()).get();
    employeeMasterFromDb.setId(employeeMaster1.getId());
	employeeMasterFromDb.setRole(employeeMaster1.getRole());
	employeeMasterFromDb.setActive(employeeMaster1.getActive());
    employeeMasterFromDb.setPassword(employeeMaster1.getPassword());
	employeeMasterFromDb.setEmail_id(employeeMaster1.getEmail_id());
	employeeMasterFromDb.setFirst_Name(employeeMaster1.getFirst_Name());
	employeeMasterFromDb.setLast_Name(employeeMaster1.getLast_Name());
	eRepo.save(employeeMaster1);

	}
}
