package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.JobTitle;
import com.metacube.training.repository.JobTitleRepository;

@Service
@Transactional
public class JobTitleServiceImpl implements JobTitleService{
	
	@Autowired
	private JobTitleRepository<JobTitle> jobTitleRepository;

	public JobTitle getJobTitleById(Long id) {
		return jobTitleRepository.findOne(id);
	}

	public List<JobTitle> getAllJobTitles() {
		return jobTitleRepository.findAll();
	}

	public boolean deleteJobTitle(Long id) {
		JobTitle jobTitle = jobTitleRepository.findOne(id);
		jobTitleRepository.delete(jobTitle);
		return true;
	}

	public boolean updateJobTitle(JobTitle jobTitle) {
		jobTitleRepository.save(jobTitle);
		return true;
	}

	public boolean createJobTitle(JobTitle jobTitle) {
		jobTitleRepository.save(jobTitle);
		return true;
	}

}
