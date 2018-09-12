package com.metacube.training.dao;

import java.util.List;

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

import com.metacube.training.model.JobTitle;
import com.metacube.training.model.Skill;

@Repository
@Transactional
public class JobTitleDAOImpl implements JobTitleDAO{

	@Autowired
	private SessionFactory sessionFactory;

	public JobTitle getJobTitleById(Long id) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(JobTitle.class);
		crit.add(Restrictions.eq("job_code", id));
		return (JobTitle) crit.uniqueResult();
	}

	public List<JobTitle> getAllJobTitles() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(JobTitle.class);
		return crit.list();
	}

	public boolean deleteJobTitle(JobTitle jobTitle) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "DELETE FROM JobTitle WHERE job_code = :id";
		int result = session.createQuery(hql)
				.setParameter("id", jobTitle.getJob_code())
				.executeUpdate();
		tx.commit();
		session.close();
		return result > 0;
	}

	public boolean updateJobTitle(JobTitle jobTitle) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "UPDATE JobTitle SET job_title = :title WHERE job_code = :id";
		int result = session.createQuery(hql)
				.setParameter("title", jobTitle.getJob_title())
				.setParameter("id", jobTitle.getJob_code())
				.executeUpdate();
		tx.commit();
		session.close();
		return result > 0;
	}

	public boolean createJobTitle(JobTitle jobTitle) {
		return sessionFactory.getCurrentSession().save(jobTitle) != null;
	}

}
