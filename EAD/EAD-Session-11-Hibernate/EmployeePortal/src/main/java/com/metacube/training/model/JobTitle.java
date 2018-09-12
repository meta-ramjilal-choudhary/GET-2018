package com.metacube.training.model;

import javax.persistence.*;

@Entity
@Table(name="job_title_master")
public class JobTitle {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="job_code")
	private Long job_code;
	
	@Column(name="job_title")
	private String job_title;
	
	public Long getJob_code() {
		return job_code;
	}
	public void setJob_code(Long job_code) {
		this.job_code = job_code;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
}
