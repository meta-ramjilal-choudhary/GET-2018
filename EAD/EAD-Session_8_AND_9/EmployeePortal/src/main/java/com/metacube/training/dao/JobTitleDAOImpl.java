package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mappers.JobTitleMapper;
import com.metacube.training.model.JobTitle;

@Repository
public class JobTitleDAOImpl implements JobTitleDAO{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	JobTitleDAOImpl(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private final String SQL_FIND_JOBTITLE = "SELECT * FROM job_title_master WHERE job_code = ?";
	private final String SQL_GETALL = "SELECT * FROM job_title_master";
	private final String SQL_INSERT_JOBTITLE = "INSERT INTO job_title_master(job_title) VALUES(?)";
	private final String SQL_UPDATE_JOBTITLE = "UPDATE job_title_master SET job_title = ? WHERE job_code = ?";
	private final String SQL_DELETE_JOBTITLE = "DELETE FROM job_title_master WHERE job_code = ?";
	
	public JobTitle getJobTitleById(Long id) {
		return jdbcTemplate.queryForObject(SQL_FIND_JOBTITLE, new Object[] {id}, new JobTitleMapper());
	}

	public List<JobTitle> getAllJobTitles() {
		return jdbcTemplate.query(SQL_GETALL, new JobTitleMapper());
	}

	public boolean deleteJobTitle(JobTitle jobTitle) {
		return jdbcTemplate.update(SQL_DELETE_JOBTITLE, jobTitle.getJob_code()) > 0;
	}

	public boolean updateJobTitle(JobTitle jobTitle) {
		return jdbcTemplate.update(SQL_UPDATE_JOBTITLE, jobTitle.getJob_title(), jobTitle.getJob_code()) > 0;
	}

	public boolean createJobTitle(JobTitle jobTitle) {
		return jdbcTemplate.update(SQL_INSERT_JOBTITLE, jobTitle.getJob_title()) > 0;
	}

}
