package com.metacube.training.EmployeePortalWithSpringBoot.dao;

import java.util.List;

import com.metacube.training.EmployeePortalWithSpringBoot.model.JobTitle;


public interface JobTitleDAO {

	JobTitle getJobTitleById(Long id);
	
	List<JobTitle> getAllJobTitles();
	
	boolean deleteJobTitle(JobTitle jobTitle);
	
	boolean updateJobTitle(JobTitle jobTitle);
	
	boolean createJobTitle(JobTitle jobTitle);
}
