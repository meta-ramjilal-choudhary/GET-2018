package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Skill;
import com.metacube.training.repository.SkillRepository;

@Service
@Transactional
public class SkillServiceImpl implements SkillService{
	
	@Autowired
	private SkillRepository<Skill> skillRepository;

	public Skill getSkillById(Long id) {
		return skillRepository.findOne(id);
	}

	public List<Skill> getAllSkills() {
		return skillRepository.findAll();
	}

	public boolean deleteSkill(Long id) {
		Skill skill = skillRepository.findOne(id);
		skillRepository.delete(skill);
		return true;
	}

	public boolean updateSkill(Skill skill) {
		skillRepository.save(skill);
		return true;
	}

	public boolean createSkill(Skill skill) {
		skillRepository.save(skill);
		return true;
	}

}
