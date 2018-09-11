package com.metacube.training.EmployeePortalWithSpringBoot.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class JobDetail {

	private Long emp_code;
	private Long job_detail_id;
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private Date date_of_joining;
	private int total_exp;
	private Long job_code;
	private Long reporting_mgr;
	private Long team_lead;
	private Long curr_proj_id;
	public Long getEmp_code() {
		return emp_code;
	}
	public void setEmp_code(Long emp_code) {
		this.emp_code = emp_code;
	}
	public Long getJob_detail_id() {
		return job_detail_id;
	}
	public void setJob_detail_id(Long job_detail_id) {
		this.job_detail_id = job_detail_id;
	}
	public Date getDate_of_joining() {
		return date_of_joining;
	}
	public void setDate_of_joining(Date date_of_joining) {
		this.date_of_joining = date_of_joining;
	}
	public int getTotal_exp() {
		return total_exp;
	}
	public void setTotal_exp(int total_exp) {
		this.total_exp = total_exp;
	}
	public Long getJob_code() {
		return job_code;
	}
	public void setJob_code(Long job_code) {
		this.job_code = job_code;
	}
	public Long getReporting_mgr() {
		return reporting_mgr;
	}
	public void setReporting_mgr(Long reporting_mgr) {
		this.reporting_mgr = reporting_mgr;
	}
	public Long getTeam_lead() {
		return team_lead;
	}
	public void setTeam_lead(Long team_lead) {
		this.team_lead = team_lead;
	}
	public Long getCurr_proj_id() {
		return curr_proj_id;
	}
	public void setCurr_proj_id(Long curr_proj_id) {
		this.curr_proj_id = curr_proj_id;
	}
	
}
