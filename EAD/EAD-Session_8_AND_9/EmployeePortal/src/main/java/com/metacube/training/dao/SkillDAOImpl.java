package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mappers.SkillMapper;
import com.metacube.training.model.Skill;

@Repository
public class SkillDAOImpl implements SkillDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public SkillDAOImpl(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private final String SQL_FIND_SKILL = "SELECT * FROM skills_master WHERE skill_id = ?";
	private final String SQL_GET_ALL = "SELECT * FROM skills_master";
	private final String SQL_INSERT_SKILLS = "INSERT INTO skills_master(skill_name) VALUES(?)";
	private final String SQL_UPDATE_SKILLS = "UPDATE skills_master SET skill_name = ? WHERE skill_id = ?";
	private final String SQL_DELETE_SKILLS = "DELETE FROM skills_master WHERE skill_id = ?";

	public Skill getSkillById(Long id) {
		return jdbcTemplate.queryForObject(SQL_FIND_SKILL, new Object[] { id }, new SkillMapper());
	}

	public List<Skill> getAllSkills() {
		return jdbcTemplate.query(SQL_GET_ALL, new SkillMapper());
	}

	public boolean deleteSkill(Skill skill) {
		return jdbcTemplate.update(SQL_DELETE_SKILLS, skill.getSkill_id()) > 0;
	}

	public boolean updateSkill(Skill skill) {
		return jdbcTemplate.update(SQL_UPDATE_SKILLS, skill.getSkill_name(), skill.getSkill_id()) > 0;
	}

	public boolean createSkill(Skill skill) {
		return jdbcTemplate.update(SQL_INSERT_SKILLS, skill.getSkill_name()) > 0;
	}
	
}
