package com.day571.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "dept")
@ToString
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;

	@OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
	private Set<Employee> employeeList;

	public Department(String s, Set<Employee> e) {
		this.name = s;
		this.employeeList = e;
	}

	public Department(int i, String string) {
		this.id=i;
		this.name=string;
	}
}
