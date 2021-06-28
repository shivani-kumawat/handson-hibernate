package com.traineeManager;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.traineeManager.model.Trainee;
import com.traineeManager.service.TraineeService;

@SpringBootApplication
public class TraineeManagerApplication {

	public static void main(String[] args) {
		
	ApplicationContext ctx=	SpringApplication.run(TraineeManagerApplication.class, args);
	TraineeService tr=(TraineeService) ctx.getBean("trainee");
	Logger logger=LoggerFactory.getLogger(TraineeManagerApplication.class);

    logger.info("This is application file ");
	
    //create new trainee
	tr.createTrainee(new Trainee(907118,"ishita","ishita.kumawat98@gmail.com","ABA90AA09"));
	
	
	//findTraineeByname
	List<Trainee> li=tr.findByTraineeName("kumar");
	System.out.println(li);
	
	//Get list of all trainees
	List<Trainee> li1=tr.getAllTrainee();
	System.out.println(li1);
	
	//remove all trainess
	String st=tr.removeTrainee(34);
	System.out.println(st);
	} 

}
