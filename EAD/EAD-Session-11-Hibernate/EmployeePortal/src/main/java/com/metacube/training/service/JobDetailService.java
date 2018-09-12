package com.metacube.training.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.metacube.training.model.JobDetail;
import com.metacube.training.model.JobTitle;

public interface JobDetailService {
	
	JobDetail getJobDetailByEmpId(Long id);
	
	List<JobDetail> getAllJobDetail();
	
	boolean deleteJobDetail(Long id);
	
	boolean updateJobDetail(JobDetail jobDetail);
	
	boolean createJobDetail(JobDetail jobDetail);
}
