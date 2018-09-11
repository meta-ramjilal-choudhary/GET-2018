package com.metacube.training.EmployeePortalWithSpringBoot.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.EmployeePortalWithSpringBoot.mappers.JobDetailMapper;
import com.metacube.training.EmployeePortalWithSpringBoot.model.JobDetail;


@Repository
public class JobDetailDAOImpl implements JobDetailDAO{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	JobDetailDAOImpl(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private final String SQL_FIND_JOBDETAIL = "SELECT * FROM job_details WHERE emp_code = ?";
	private final String SQL_GETALL = "SELECT * FROM job_details";
	private final String SQL_DELETE_JOBDETAIL = "DELETE FROM job_details WHERE emp_code = ?";
	private final String SQL_INSERT_JOBDETAIL = "INSERT INTO job_details"
			+ "(emp_code, date_of_joining, total_exp, job_code, reporting_mgr, team_lead, curr_proj_id) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
	private final String SQL_UPDATE_JOBDETAIL = "UPDATE job_details SET date_of_joining = ?, total_exp=?, "
			+ "job_code = ?, reporting_mgr = ?, team_lead = ?, curr_proj_id = ?";
	
	public JobDetail getJobDetailByEmpId(Long id) {
		return jdbcTemplate.queryForObject(SQL_FIND_JOBDETAIL,  new Object[] {id}, new JobDetailMapper());
	}

	public List<JobDetail> getAllJobDetail() {
		return jdbcTemplate.query(SQL_GETALL, new JobDetailMapper());
	}

	public boolean deleteJobDetail(JobDetail jobDetail) {
		return jdbcTemplate.update(SQL_DELETE_JOBDETAIL, jobDetail.getEmp_code()) > 0;
	}

	public boolean updateJobDetail(JobDetail jobDetail) {
		return jdbcTemplate.update(SQL_UPDATE_JOBDETAIL, jobDetail.getDate_of_joining(), dateDiff(jobDetail.getDate_of_joining()), 
				jobDetail.getJob_code(), jobDetail.getReporting_mgr(), jobDetail.getTeam_lead(), jobDetail.getCurr_proj_id()) > 0;
	}

	public boolean createJobDetail(JobDetail jobDetail) {
		return jdbcTemplate.update(SQL_INSERT_JOBDETAIL, jobDetail.getEmp_code(), jobDetail.getDate_of_joining(), 
				dateDiff(jobDetail.getDate_of_joining()), jobDetail.getJob_code(), jobDetail.getReporting_mgr(),
				jobDetail.getTeam_lead(), jobDetail.getCurr_proj_id()) > 0;
	}
	
	public int dateDiff(Date date){
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
			Date firstDate = sdf.parse(date.toString());
			Date secondDate = sdf.parse((new Date()).toString());
			long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
			long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
			return (int)diff;
		}catch(ParseException e){
			System.out.println(e.getMessage());
			return 0;
		}
	}

}
