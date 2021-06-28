package com.day571.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day571.model.Department;
import com.day571.model.Employee;
import com.day571.repository.DepartmentRepository;

@Service("dept")
public class DepartmentService {
	Logger logger = LoggerFactory.getLogger(DepartmentService.class);
	@Autowired
	public DepartmentRepository depo;
	public void save(Department employee) {
		logger.info("Start");
		depo.save(employee);
		logger.info("End");
	}
	
	public Optional<Department> testGetDepartment(int id){
		
		return depo.findById(id);
	}
	
	

}
