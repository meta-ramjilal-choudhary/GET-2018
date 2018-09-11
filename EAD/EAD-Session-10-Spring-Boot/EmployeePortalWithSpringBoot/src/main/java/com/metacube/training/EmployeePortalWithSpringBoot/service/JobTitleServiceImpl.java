package com.metacube.training.EmployeePortalWithSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeePortalWithSpringBoot.dao.JobTitleDAO;
import com.metacube.training.EmployeePortalWithSpringBoot.model.JobTitle;


@Service
public class JobTitleServiceImpl implements JobTitleService{

	@Autowired
	private JobTitleDAO jobTitleDAO;
	
	public JobTitle getJobTitleById(Long id) {
		return jobTitleDAO.getJobTitleById(id);
	}

	public List<JobTitle> getAllJobTitles() {
		return jobTitleDAO.getAllJobTitles();
	}

	public boolean deleteJobTitle(Long id) {
		JobTitle jobTitle = jobTitleDAO.getJobTitleById(id);
		return jobTitleDAO.deleteJobTitle(jobTitle);
	}

	public boolean updateJobTitle(JobTitle jobTitle) {
		return jobTitleDAO.updateJobTitle(jobTitle);
	}

	public boolean createJobTitle(JobTitle jobTitle) {
		return jobTitleDAO.createJobTitle(jobTitle);
	}

}
