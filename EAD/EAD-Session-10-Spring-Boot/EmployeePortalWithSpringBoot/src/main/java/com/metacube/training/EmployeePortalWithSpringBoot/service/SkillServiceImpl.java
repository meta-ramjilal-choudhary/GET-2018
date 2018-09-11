package com.metacube.training.EmployeePortalWithSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeePortalWithSpringBoot.dao.SkillDAO;
import com.metacube.training.EmployeePortalWithSpringBoot.model.Skill;

@Service
public class SkillServiceImpl implements SkillService{
	
	@Autowired
	private SkillDAO skillDAO;

	public Skill getSkillById(Long id) {
		return skillDAO.getSkillById(id);
	}

	public List<Skill> getAllSkills() {
		return skillDAO.getAllSkills();
	}

	public boolean deleteSkill(Long id) {
		Skill skill = skillDAO.getSkillById(id);
		return skillDAO.deleteSkill(skill);
	}

	public boolean updateSkill(Skill skill) {
		return skillDAO.updateSkill(skill);
	}

	public boolean createSkill(Skill skill) {
		return skillDAO.createSkill(skill);
	}
	
	
}
