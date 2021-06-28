package com.day571.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.day571.model.Skill;
@Repository
public interface SkillRepository  extends JpaRepository<Skill,Integer>{
	

}
