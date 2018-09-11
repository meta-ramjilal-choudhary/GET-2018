package com.metacube.training.EmployeePortalWithSpringBoot.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.EmployeePortalWithSpringBoot.model.JobDetail;


public class JobDetailMapper implements RowMapper<JobDetail>{

	@Override
	public JobDetail mapRow(ResultSet resultSet, int i) throws SQLException {
		JobDetail jobDetail = new JobDetail();
		jobDetail.setEmp_code(resultSet.getLong("emp_code"));
		jobDetail.setJob_detail_id(resultSet.getLong("job_detail_id"));
		jobDetail.setDate_of_joining(resultSet.getDate("date_of_joining"));
		jobDetail.setTotal_exp(resultSet.getInt("total_exp"));
		jobDetail.setJob_code(resultSet.getLong("job_code"));
		jobDetail.setReporting_mgr(resultSet.getLong("reporting_mgr"));
		jobDetail.setTeam_lead(resultSet.getLong("team_lead"));
		jobDetail.setCurr_proj_id(resultSet.getLong("curr_proj_id"));
		return jobDetail;
	}

}
