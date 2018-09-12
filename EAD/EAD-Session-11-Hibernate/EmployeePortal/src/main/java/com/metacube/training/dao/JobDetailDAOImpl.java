package com.metacube.training.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

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

import com.metacube.training.model.JobDetail;
import com.metacube.training.model.Project;

@Repository
@Transactional
public class JobDetailDAOImpl implements JobDetailDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public JobDetail getJobDetailByEmpId(Long id) {
		Criteria crit = sessionFactory.openSession().createCriteria(JobDetail.class);
		crit.add(Restrictions.eq("emp_code", id));
		return (JobDetail) crit.uniqueResult();
	}

	public List<JobDetail> getAllJobDetail() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(JobDetail.class);
		return crit.list();
	}

	public boolean deleteJobDetail(JobDetail jobDetail) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "DELETE FROM JobDetail WHERE emp_code = :id";
		int result = session.createQuery(hql)
				.setParameter("id", jobDetail.getEmp_code())
				.executeUpdate();
		tx.commit();
		session.close();
		return result > 0;
	}

	public boolean updateJobDetail(JobDetail jobDetail) {
		String hql = "UPDATE JobDetail SET date_of_joining = :joinDate, total_exp=:totalExp, "
				+ "job_code = :job_code, reporting_mgr = :mgr, team_lead = :lead, curr_proj_id = :proj WHERE emp_code = :emp";
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		int result = session.createQuery(hql)
				.setParameter("joinDate", jobDetail.getDate_of_joining())
				.setParameter("totalExp", dateDiff(jobDetail.getDate_of_joining()) )
				.setParameter("job_code", jobDetail.getJob_code())
				.setParameter("mgr", jobDetail.getReporting_mgr())
				.setParameter("lead", jobDetail.getTeam_lead())
				.setParameter("proj", jobDetail.getCurr_proj_id())
				.setParameter("emp", jobDetail.getEmp_code())
				.executeUpdate();
		tx.commit();
		session.close();
		return result > 0;
		
	}

	public boolean createJobDetail(JobDetail jobDetail) {
		return sessionFactory.getCurrentSession().save(jobDetail) != null;
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
