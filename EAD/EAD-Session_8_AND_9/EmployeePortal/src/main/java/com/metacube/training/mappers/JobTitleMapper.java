package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.JobTitle;

public class JobTitleMapper implements RowMapper<JobTitle>{

	@Override
	public JobTitle mapRow(ResultSet resultSet, int i) throws SQLException {
		JobTitle jobTitle = new JobTitle();
		jobTitle.setJob_code(resultSet.getLong("job_code"));
		jobTitle.setJob_title(resultSet.getString("job_title"));
		return jobTitle;
	}

}
