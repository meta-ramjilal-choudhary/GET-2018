package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Project;
import com.metacube.training.model.Skill;

@Repository
@Transactional
public class ProjectDAOImpl implements ProjectDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Project getProjectById(Long id) {
		Criteria crit = sessionFactory.openSession().createCriteria(Project.class);
		crit.add(Restrictions.eq("project_id", id));
		return (Project) crit.uniqueResult();
	}

	public List<Project> getAllProjects() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Project.class);
		return crit.list();
	}

	public boolean deleteProject(Project project) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "DELETE FROM Project WHERE project_id = :id";
		int result = session.createQuery(hql)
				.setParameter("id", project.getProject_id())
				.executeUpdate();
		tx.commit();
		session.close();
		return result > 0;
	}

	public boolean updateProject(Project project) {
		String hql = "UPDATE Project SET description = :desc, start_date  = :startDate,"
				+ " end_date  = :endDate, project_logo = :logo WHERE project_id = :id";
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		int result = session.createQuery(hql)
				.setParameter("desc", project.getDescription())
				.setParameter("startDate", project.getStartDate())
				.setParameter("endDate", project.getEndDate())
				.setParameter("logo", project.getProject_logo())
				.setParameter("id", project.getProject_id())
				.executeUpdate();
		tx.commit();
		session.close();
		return result > 0;
	}

	public boolean createProject(Project project) {
		return sessionFactory.getCurrentSession().save(project) != null;
	}

}