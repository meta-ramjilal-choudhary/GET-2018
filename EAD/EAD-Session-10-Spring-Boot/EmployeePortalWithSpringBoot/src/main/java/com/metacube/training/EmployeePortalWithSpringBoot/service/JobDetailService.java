package com.metacube.training.EmployeePortalWithSpringBoot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.metacube.training.EmployeePortalWithSpringBoot.model.JobDetail;


public interface JobDetailService {
	
	JobDetail getJobDetailByEmpId(Long id);
	
	List<JobDetail> getAllJobDetail();
	
	boolean deleteJobDetail(Long id);
	
	boolean updateJobDetail(JobDetail jobDetail);
	
	boolean createJobDetail(JobDetail jobDetail);
}
