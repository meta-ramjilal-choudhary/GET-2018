package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mappers.ProjectMapper;
import com.metacube.training.model.Project;

@Repository
public class ProjectDAOImpl implements ProjectDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public ProjectDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private final String SQL_FIND_PROJECT = "SELECT * FROM project_master WHERE project_id = ?";
	private final String SQL_DELETE_PROJECT = "DELETE FROM project_master WHERE project_id = ?";
	private final String SQL_UPDATE_PROJECT = "UPDATE project_master SET description = ?, "
			+ " start_date  = ?, end_date  = ?, project_logo = ? WHERE project_id = ?";
	private final String SQL_GET_ALL = "SELECT * FROM project_master";
	private final String SQL_INSERT_PROJECT = "INSERT INTO project_master(description, start_date, end_date, project_logo)"
			+ " VALUES (?,?,?,?)";

	public Project getProjectById(Long id) {
		return jdbcTemplate.queryForObject(SQL_FIND_PROJECT, new Object[] { id }, new ProjectMapper());
	}

	public List<Project> getAllProjects() {
		return jdbcTemplate.query(SQL_GET_ALL, new ProjectMapper());
	}

	public boolean deleteProject(Project project) {
		return jdbcTemplate.update(SQL_DELETE_PROJECT, project.getProject_id()) > 0;
	}

	public boolean updateProject(Project project) {
		return jdbcTemplate.update(SQL_UPDATE_PROJECT, project.getDescription(), project.getStartDate(),
				project.getEndDate(), project.getProject_logo(), project.getProject_id() ) > 0;
	}

	public boolean createProject(Project project) {
		return jdbcTemplate.update(SQL_INSERT_PROJECT, project.getDescription(), project.getStartDate(),
				project.getEndDate(), project.getProject_logo()) > 0;
	}

}