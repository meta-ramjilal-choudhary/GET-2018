package com.metacube.training.model;

import javax.persistence.*;

@Entity
@Table(name="job_title_master")
public class JobTitle {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="job_code")
	private Long jobCode;
	
	@Column(name="job_title")
	private String jobTitle;

	public Long getJobCode() {
		return jobCode;
	}

	public void setJobCode(Long jobCode) {
		this.jobCode = jobCode;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
}
