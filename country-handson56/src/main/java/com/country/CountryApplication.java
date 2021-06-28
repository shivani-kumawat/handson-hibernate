package com.country;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import com.country.entity.Country;
import com.country.service.CountryService;

@SpringBootApplication
public class CountryApplication {

	public static void main(String[] args) {
		
		ApplicationContext ctx= SpringApplication.run(CountryApplication.class, args);
		Logger logger=LoggerFactory.getLogger(CountryApplication.class);
		logger.info("Inside main class");
		CountryService cs=(CountryService) ctx.getBean("con");
		
		String s=cs.createCountry(new Country("in","INDIA"));
		System.out.println(s);
		
//		Country c=new Country();
//		c.setCode("in");
//		c.setName("AMERICA");
//		cs.updateCountry(c);
		
//		 List<Country> li=cs.findByNameStarts("A");
//		 System.out.println(li);
		
//		Optional<Country> li=cs.findBasedOnCode("in");
//		System.out.println(li);
		
//		List<Country> li=cs.findByPartialNameOfCountry("CA");
//		System.out.println(li);
//		li.stream().forEach(l->System.out.println(l.getCode()+l.getName()));
//		
	}

}
