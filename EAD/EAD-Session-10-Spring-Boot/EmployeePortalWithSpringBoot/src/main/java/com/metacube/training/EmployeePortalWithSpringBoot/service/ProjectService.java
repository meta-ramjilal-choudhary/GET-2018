package com.metacube.training.EmployeePortalWithSpringBoot.service;

import java.util.List;

import com.metacube.training.EmployeePortalWithSpringBoot.model.Project;


public interface ProjectService {

	
	public Project getProjectById(Long id);

	public List<Project> getAllProjects();

	public boolean deleteProject(Long id);

	public boolean updateProject(Project project);

	public boolean createProject(Project project);

}
