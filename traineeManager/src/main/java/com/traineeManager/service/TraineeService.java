package com.traineeManager.service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traineeManager.TraineeManagerApplication;
import com.traineeManager.exception.InvalidTraineeDataException;
import com.traineeManager.exception.InvalidTraineeoperationException;
import com.traineeManager.model.Trainee;
import com.traineeManager.repository.ITraineeRepository;

@Service("trainee")

public class TraineeService {
	Logger logger = LoggerFactory.getLogger(TraineeService.class);
	@Autowired
	private ITraineeRepository repo;

	public static boolean isAlpha(String s) {
		if (s == null) {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z')) {
				return false;
			}
		}
		return true;
	}

	public void createTrainee(Trainee t) {
		
		try {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		String email = t.getEmail();
		Matcher matcher = pattern.matcher(email);
		boolean e = matcher.matches();
		String code=t.getCohort_code();
		boolean codeCheck=Pattern.matches("[A-Z]{3}[0-9]{2}[A-Z]{2}[0-9]{2}",code );
		int len = String.valueOf(t.getEmpId()).length();
		
		String s = t.getName();
		boolean b = isAlpha(s);
		
		//int id=t.getEmpId();
		Optional<Trainee> op = repo.findById(t.getEmpId());
		if (op.isPresent()) {
			logger.info("In the Trainee service class");
			logger.info("Trainee already exists");
			throw new InvalidTraineeoperationException("\nEmploye already Exists");
		}
		
		else {
		if (len == 6 && b && e && codeCheck) {
			repo.saveAndFlush(t);
			logger.info("In the Trainee service class");
			logger.info("Trainee created");
			System.out.println("\nCreated");
		}
		else {
		throw new InvalidTraineeDataException("Object cannot be created");
		}
		}
		}
		catch(InvalidTraineeDataException exp){
			logger.info("In the Trainee service class");
			logger.info("Trainee object cannot be created,provide valid format");
			System.out.println("Catch Block") ;
			System.out.println(exp) ;
		}
		catch(InvalidTraineeoperationException exp) {
			logger.info("In the Trainee service class");
			logger.info("Trainee object cannot be created,id already exists");
			System.out.println("Catch Block") ;
			System.out.println(exp) ;
		}
		
	}
	
	
	public List<Trainee> getAllTrainee() {
		logger.info("List of all the trainees ");
		return repo.findAll();
	}

	public Trainee getTraineeById(int sid) {
		Optional<Trainee> op = repo.findById(sid);
		logger.info("In the Trainee service class");
		if (op.isPresent()) {
			logger.info("The trainee belong to id:{} is",sid);
			return op.get();
		}
		else
		{
			logger.error("Given trainee id does not exist");
			return null;
		}
			
	}

	public String removeTrainee(int tid) {
		Optional<Trainee> op = repo.findById(tid);
		logger.info("In the Trainee service class");
		if (op.isPresent()) {
			repo.delete(op.get());
			logger.info("Trainee deleted");
			return "Trainee Deleted!!!!";
		} else {
			logger.info("Trainee with given id does not exist");
			return "Trainee Not Available";
		}
	}

	public List<Trainee> findByTraineeName(String name) {
		return repo.findByName(name);
	}

}
