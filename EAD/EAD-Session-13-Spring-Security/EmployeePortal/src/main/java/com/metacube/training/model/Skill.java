package com.metacube.training.model;

import javax.persistence.*;

@Entity
@Table(name="skills_master")
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="skill_id")
	private Long skillId;
	
	@Column(name="skill_name")
	private String skillName;
	
	public Skill(){
		
	}

	public Long getSkillId() {
		return skillId;
	}

	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

}
