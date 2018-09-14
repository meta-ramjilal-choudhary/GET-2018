package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Project;
import com.metacube.training.repository.ProjectRepository;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectRepository<Project> projectRepository;
	
	public Project getProjectById(Long id) {
		return projectRepository.findOne(id);
	}

	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	public boolean deleteProject(Long id) {
		Project project = projectRepository.findOne(id);
		projectRepository.delete(project);
		return true;
	}

	public boolean updateProject(Project project) {
		projectRepository.save(project);
		return true;
	}

	public boolean createProject(Project project) {
		projectRepository.save(project);
		return true;
	}

}
