package com.day571;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.day571.model.Department;
import com.day571.model.Employee;
import com.day571.model.Skill;
import com.day571.service.DepartmentService;
import com.day571.service.EmployeeService;
import com.day571.service.SkillService;



@SpringBootApplication
public class Day571Application {

	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(Day571Application.class, args);
		SkillService skill=(SkillService) ctx.getBean("skill");
		EmployeeService ss=(EmployeeService) ctx.getBean("emp");
		DepartmentService d=(DepartmentService) ctx.getBean("dept");
		
		//many to one mapping between department and employee
		//department bean and create new department
		Department d1=new Department(1,"me");
		d.save(d1);
//		
		//Employee bean and create employee with department
//		EmployeeService ss=(EmployeeService) ctx.getBean("emp");
//		List<Employee> li= new ArrayList<Employee>();
//		li.add(new Employee(3,"shivani",2000,true,"23-03-2019",d1));
//		li.add(new Employee(2,"chab",2000,true,"23-03-2019",d1));
//		ss.save(li);
//		
		
		
		
		/* for department handson no 6  where  one to many mapping is there between employee and department*/ 
//		EmployeeService ss=(EmployeeService) ctx.getBean("emp");
//		List<Employee> li= new ArrayList<Employee>();
//		li.add(new Employee(1,"chabdi",2000,true,"23-03-2019"));
//		li.add(new Employee(2,"chab",2000,true,"23-03-2019"));
//		ss.save(li);
//		DepartmentService d=(DepartmentService) ctx.getBean("dept");
//		Department d1=new Department(1,"me",li);
//		d.save(d1);
		
		
//		//list of permanent employees
		List<Employee> li=ss.getAllPermanentEmployees();
		System.out.println(li);
		
//		//avg salary of users
		double s=ss.getAverageSalary(1);
		System.out.println(s);
//		
//		//get all users using native query
		List<Employee> e1=ss.getAllEmployeesNative();
		System.out.println(e1);
	
		
		//get employee by id
		Employee e=ss.get(2);
		System.out.println(e);
		
		
		//many to many relation between employee and skill table
		
//		SkillService skill=(SkillService) ctx.getBean("skill");
		Skill s1=new Skill(2,"good at analyzing");
		
//		EmployeeService ss=(EmployeeService) ctx.getBean("emp");
		Employee li1= new Employee(4,"kumar",2000,false,"23-03-2019",d1,s1);
		ss.save(li1);
	}
	

}
