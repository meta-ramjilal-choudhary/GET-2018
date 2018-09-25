package com.metacube.training.model;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "project_master")
public class Project {
	
	@Id
	@Column(name="project_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long projectId;
	
	@Column(name="description")
	private String description;
	
	@Column(name="start_date")
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Column(name="end_date")
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	@Column(name="project_logo")
	private String projectLogo;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectLogo() {
		return projectLogo;
	}

	public void setProjectLogo(String projectLogo) {
		this.projectLogo = projectLogo;
	}

}
