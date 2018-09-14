package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.JobTitle;

public interface JobTitleService {

	JobTitle getJobTitleById(Long id);
	
	List<JobTitle> getAllJobTitles();
	
	boolean deleteJobTitle(Long id);
	
	boolean updateJobTitle(JobTitle jobTitle);
	
	boolean createJobTitle(JobTitle jobTitle);
	
}
