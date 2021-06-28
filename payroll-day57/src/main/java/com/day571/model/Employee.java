package com.day571.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "EMPLOYEE_HANDSON")
@Getter
@Setter
@ToString
@NoArgsConstructor

public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eid;
	private String name;
	private double salary;
	private boolean permanent;
	private String dateOfBirth;

	@ManyToOne
	@JoinColumn(name = "em_dp_id")
	private Department department;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "employee_skill",
	joinColumns = @JoinColumn(name = "es_em_id"),
	inverseJoinColumns = @JoinColumn(name = "es_sk_id"))
	private Skill skillList;

	public Employee(int id, String string, double i, boolean b, String string2, Department d1) {
		this.eid = id;
		this.name = string;
		this.permanent = b;
		this.dateOfBirth = string2;
		this.salary = i;
		this.department = d1;

	}

	// constructor for one to many mapping between department and employee
	public Employee(int id, String string, double i, boolean b, String string2) {
		this.eid = id;
		this.name = string;
		this.permanent = b;
		this.dateOfBirth = string2;
		this.salary = i;
	}

	public Employee(int id, String string, double i, boolean b, String string2, Department d, Skill s) {
		this.eid = id;
		this.name = string;
		this.permanent = b;
		this.dateOfBirth = string2;
		this.salary = i;
		this.department = d;
		this.skillList = s;
	}

}
