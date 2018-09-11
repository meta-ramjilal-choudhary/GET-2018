package com.metacube.training.EmployeePortalWithSpringBoot.service;

import java.util.List;

import com.metacube.training.EmployeePortalWithSpringBoot.model.JobTitle;


public interface JobTitleService {

	JobTitle getJobTitleById(Long id);
	
	List<JobTitle> getAllJobTitles();
	
	boolean deleteJobTitle(Long id);
	
	boolean updateJobTitle(JobTitle jobTitle);
	
	boolean createJobTitle(JobTitle jobTitle);
}
