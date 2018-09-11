package com.metacube.training.EmployeePortalWithSpringBoot.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Employee {

	private Long emp_code;
	private String first_name;
	private String middle_name;
	private String last_name;
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private Date dob;
	private String gender;
	private String primary_contact_no;
	private String secondary_contact_no;
	private String email_id;
	private String skype_id;
	private String profile_picture;
	private String password;
	private boolean enabled;
	
	public Long getEmp_code() {
		return emp_code;
	}
	public void setEmp_code(Long emp_code) {
		this.emp_code = emp_code;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getMiddle_name() {
		return middle_name;
	}
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getPrimary_contact_no() {
		return primary_contact_no;
	}
	public void setPrimary_contact_no(String primary_contact_no) {
		this.primary_contact_no = primary_contact_no;
	}
	public String getSecondary_contact_no() {
		return secondary_contact_no;
	}
	public void setSecondary_contact_no(String secondary_contact_no) {
		this.secondary_contact_no = secondary_contact_no;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getSkype_id() {
		return skype_id;
	}
	public void setSkype_id(String skype_id) {
		this.skype_id = skype_id;
	}
	public String getProfile_picture() {
		return profile_picture;
	}
	public void setProfile_picture(String profile_picture) {
		this.profile_picture = profile_picture;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
