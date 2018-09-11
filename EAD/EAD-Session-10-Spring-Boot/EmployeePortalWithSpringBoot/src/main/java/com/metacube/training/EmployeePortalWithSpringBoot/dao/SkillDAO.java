package com.metacube.training.EmployeePortalWithSpringBoot.dao;

import java.util.List;

import com.metacube.training.EmployeePortalWithSpringBoot.model.Skill;


public interface SkillDAO {

	Skill getSkillById(Long id);

	List<Skill> getAllSkills();

	boolean deleteSkill(Skill skill);

	boolean updateSkill(Skill skill);

	boolean createSkill(Skill skill);
}
