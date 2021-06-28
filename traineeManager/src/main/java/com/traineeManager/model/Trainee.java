package com.traineeManager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "trainee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Trainee {
	@Id
	private int empId;
	private String name;
	private String email;
	private String cohort_code;

}
