package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Employee;
import com.metacube.training.model.Skill;

@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO{

	@Autowired
	private SessionFactory sessionFactory;

	public Employee getEmployeeById(Long id) {
		Criteria crit = sessionFactory.openSession().createCriteria(Employee.class);
		crit.add(Restrictions.eq("emp_code", id));
		return (Employee) crit.uniqueResult();
	}

	public List<Employee> getAllEmployees() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Employee.class);
		return crit.list();
	}

	public boolean deleteEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "DELETE FROM Employee WHERE emp_code = :emp_code";
		int result = session.createQuery(hql)
				.setParameter("emp_code", employee.getEmp_code())
				.executeUpdate();
		tx.commit();
		session.close();
		return result > 0;
	}

	public boolean updateEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "UPDATE Employee SET first_name = :first_name, "
				+ "middle_name = :middle_name, last_name = :last_name, dob = :dob, gender = :gender, primary_contact_no = :primary, "
				+ "secondary_contact_no = :secondary, email_id = :email, skype_id = :skype, profile_picture = :profile, "
				+ "password = :pwd, enabled = :enabled WHERE emp_code = :emp_code";
		int result = session.createQuery(hql)
		.setParameter("first_name", employee.getFirst_name())
		.setParameter("middle_name", employee.getMiddle_name())
		.setParameter("last_name", employee.getLast_name())
		.setParameter("dob", employee.getDob())
		.setParameter("gender", employee.getGender())
		.setParameter("primary", employee.getPrimary_contact_no())
		.setParameter("secondary", employee.getSecondary_contact_no())
		.setParameter("email", employee.getEmail_id())
		.setParameter("skype", employee.getSkype_id())
		.setParameter("profile", employee.getProfile_picture())
		.setParameter("pwd", employee.getPassword())
		.setParameter("enabled", employee.isEnabled())
		.setParameter("emp_code", employee.getEmp_code())
		.executeUpdate();
		tx.commit();
		session.close();
		return result > 0;
	}

	public boolean createEmployee(Employee employee) {
		return sessionFactory.getCurrentSession().save(employee) != null;
	}

	public List<Employee> getAllEmployeeByName(String name) {
		Criteria crit = sessionFactory.openSession().createCriteria(Employee.class);
		Criterion firstName = Restrictions.like("first_name", "%" + name + "%");
		Criterion middleName = Restrictions.like("middle_name", "%" + name + "%");
		Criterion lastName = Restrictions.like("last_name", "%" + name + "%");
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(firstName);
		disjunction.add(middleName);
		disjunction.add(lastName);
		crit.add(disjunction);
		return crit.list();
	}

}
