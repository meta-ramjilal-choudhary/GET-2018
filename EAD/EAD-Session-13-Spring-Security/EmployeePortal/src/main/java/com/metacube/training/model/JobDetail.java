package com.metacube.training.model;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="job_details")
public class JobDetail {

	@Column(name="emp_code")
	private Long employeeCode;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_detail_id")
	private Long jobDetailId;
	
	@Column(name="date_of_joining")
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dateOfJoining;
	
	@Column(name="total_exp")
	private Long totalExp;
	
	@Column(name="job_code")
	private Long jobCode;
	
	@Column(name="reporting_mgr")
	private Long reportingMgr;
	
	@Column(name="team_lead")
	private Long teamLead;
	
	@Column(name="curr_proj_id")
	private Long currProjId;

	public Long getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(Long employeeCode) {
		this.employeeCode = employeeCode;
	}

	public Long getJobDetailId() {
		return jobDetailId;
	}

	public void setJobDetailId(Long jobDetailId) {
		this.jobDetailId = jobDetailId;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Long getTotalExp() {
		return totalExp;
	}

	public void setTotalExp(Long totalExp) {
		this.totalExp = totalExp;
	}

	public Long getJobCode() {
		return jobCode;
	}

	public void setJobCode(Long jobCode) {
		this.jobCode = jobCode;
	}

	public Long getReportingMgr() {
		return reportingMgr;
	}

	public void setReportingMgr(Long reportingMgr) {
		this.reportingMgr = reportingMgr;
	}

	public Long getTeamLead() {
		return teamLead;
	}

	public void setTeamLead(Long teamLead) {
		this.teamLead = teamLead;
	}

	public Long getCurrProjId() {
		return currProjId;
	}

	public void setCurrProjId(Long currProjId) {
		this.currProjId = currProjId;
	}
		
}
