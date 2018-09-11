package com.metacube.training.EmployeePortalWithSpringBoot.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.EmployeePortalWithSpringBoot.model.Skill;


public class SkillMapper implements RowMapper<Skill>{

	@Override
	public Skill mapRow(ResultSet resultSet, int i) throws SQLException {
		Skill skill = new Skill();
		skill.setSkill_id(resultSet.getLong("skill_id"));
		skill.setSkill_name(resultSet.getString("skill_name"));
		return skill;
	}
	
}
