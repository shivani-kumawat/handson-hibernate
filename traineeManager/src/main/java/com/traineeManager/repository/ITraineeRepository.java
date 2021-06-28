package com.traineeManager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.traineeManager.model.Trainee;

public interface ITraineeRepository extends JpaRepository <Trainee,Integer>{

	public List<Trainee> findByName(String name);

}
