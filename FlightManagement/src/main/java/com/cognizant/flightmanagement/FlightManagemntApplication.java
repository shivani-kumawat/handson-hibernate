package com.cognizant.flightmanagement;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.cognizant.flightmanagement.controller.FlightController;

@SpringBootApplication
@ComponentScan("com")
public class FlightManagemntApplication {

	private static  Logger logger = LoggerFactory.getLogger(FlightController.class);
	public static void main(String[] args) {
		SpringApplication.run(FlightManagemntApplication.class, args);
		logger.info("In main class");

	}

}
