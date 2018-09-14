package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Project;

public interface ProjectService {
	
	public Project getProjectById(Long id);

	public List<Project> getAllProjects();

	public boolean deleteProject(Long id);

	public boolean updateProject(Project project);

	public boolean createProject(Project project);
}
