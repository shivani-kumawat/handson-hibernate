package com.day571.service;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.day571.model.Employee;
import com.day571.repository.EmployeeRepository;

@Service("emp")
@Transactional
public class EmployeeService {
	Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	@Autowired
	public EmployeeRepository repo;

	@Transactional
	public Employee get(int id) {
		LOGGER.info("Start");
		return repo.findById(id).get();
	}

	@Transactional
	public void save(Employee employee) {
		LOGGER.info("Start");
		repo.save(employee);
		LOGGER.info("End");
	}

	@Transactional
	public List<Employee> getAllPermanentEmployees() {
		LOGGER.info("Start");
		LOGGER.info("End");
		return repo.getAllPermanentEmployees();
	}

	public double getAverageSalary(int id) {
		return repo.getAverageSalary(id);

	}

	public List<Employee> getAllEmployeesNative() {
		return repo.getAllEmployeesNative();
	}

}
