package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.JobDetailDAO;
import com.metacube.training.model.JobDetail;
import com.metacube.training.model.JobTitle;

@Service
public class JobDetailServiceImpl implements JobDetailService{

	@Autowired
	private JobDetailDAO jobDetailDAO;
	
	public JobDetail getJobDetailByEmpId(Long id) {
		return jobDetailDAO.getJobDetailByEmpId(id);
	}

	public List<JobDetail> getAllJobDetail() {
		return jobDetailDAO.getAllJobDetail();
	}

	public boolean deleteJobDetail(Long id) {
		JobDetail jobDetail = jobDetailDAO.getJobDetailByEmpId(id);
		return jobDetailDAO.deleteJobDetail(jobDetail);
	}

	public boolean updateJobDetail(JobDetail jobDetail) {
		return jobDetailDAO.updateJobDetail(jobDetail);
	}

	public boolean createJobDetail(JobDetail jobDetail) {
		return jobDetailDAO.createJobDetail(jobDetail);
	}


}
