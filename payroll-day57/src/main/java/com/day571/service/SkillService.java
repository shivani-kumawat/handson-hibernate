package com.day571.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.day571.model.Employee;
import com.day571.model.Skill;
import com.day571.repository.SkillRepository;

@Service("skill")
public class SkillService {

	Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	@Autowired
	public SkillRepository skill;

	@Transactional

	public void save(Skill s) {

		LOGGER.info("Start");

		skill.save(s);

		LOGGER.info("End");

	}

	@Transactional
	public Skill get(int id) {

		LOGGER.info("Start");

		return skill.findById(id).get();

	}

}
