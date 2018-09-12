package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.JobDetail;

public interface JobDetailDAO {

	JobDetail getJobDetailByEmpId(Long id);
	
	List<JobDetail> getAllJobDetail();
	
	boolean deleteJobDetail(JobDetail jobDetail);
	
	boolean updateJobDetail(JobDetail jobDetail);
	
	boolean createJobDetail(JobDetail jobDetail);
}
