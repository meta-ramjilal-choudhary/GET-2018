package com.metacube.training.EmployeePortalWithSpringBoot.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.EmployeePortalWithSpringBoot.mappers.EmployeeMapper;
import com.metacube.training.EmployeePortalWithSpringBoot.model.Employee;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	EmployeeDAOImpl(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private final String SQL_FIND_EMPLOYEE = "SELECT * FROM Employee WHERE emp_code = ?";
	private final String SQL_GETALL = "SELECT * FROM Employee";
	private final String SQL_INSERT_EMPLOYEE = "INSERT INTO Employee"
			+ "(first_name, middle_name, last_name, dob, gender, primary_contact_no, "
			+ "secondary_contact_no, email_id, skype_id, profile_picture, password, enabled)"
			+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String SQL_UPDATE_EMPLOYEE = "UPDATE Employee SET first_name = ?, "
			+ "middle_name = ?, last_name = ?, dob = ?, gender = ?, primary_contact_no = ?, "
			+ "secondary_contact_no = ?, email_id = ?, skype_id = ?, profile_picture = ?, "
			+ "password = ?, enabled = ? WHERE emp_code = ?" ;
	private final String SQL_DELETE_EMPLOYEE = "DELETE FROM Employee WHERE emp_code = ?";
	private final String SQL_GETALL_BY_NAME = "SELECT * FROM Employee WHERE first_name LIKE ? "
			+ "OR middle_name LIKE ? OR last_name LIKE ?";
	private final String SQL_FIND_BY_EMAIL = "SELECT * FROM Employee WHERE email_id = ?";
	private final String SQL_UPDATE_PWD = "UPDATE Employee SET password = ? WHERE email_id = ?";
	
	public Employee getEmployeeById(Long id) {
		return jdbcTemplate.queryForObject(SQL_FIND_EMPLOYEE, new Object[] {id}, new EmployeeMapper());
	}

	public List<Employee> getAllEmployees() {
		return jdbcTemplate.query(SQL_GETALL, new EmployeeMapper());
	}

	public boolean deleteEmployee(Employee employee) {
		return jdbcTemplate.update(SQL_DELETE_EMPLOYEE, employee.getEmp_code()) > 0;
	}

	public boolean updateEmployee(Employee employee) {
		return jdbcTemplate.update(SQL_UPDATE_EMPLOYEE, employee.getFirst_name(), employee.getMiddle_name(),
				employee.getLast_name(), employee.getDob(), employee.getGender(), employee.getPrimary_contact_no(),
				employee.getSecondary_contact_no(), employee.getEmail_id(), employee.getSkype_id(), 
				employee.getProfile_picture(), employee.getPassword(), employee.isEnabled(), employee.getEmp_code()) > 0;
	}

	public boolean createEmployee(Employee employee) {
		return jdbcTemplate.update(SQL_INSERT_EMPLOYEE, employee.getFirst_name(), employee.getMiddle_name(),
				employee.getLast_name(), employee.getDob(), employee.getGender(), employee.getPrimary_contact_no(),
				employee.getSecondary_contact_no(), employee.getEmail_id(), employee.getSkype_id(), 
				employee.getProfile_picture(), employee.getPassword(), employee.isEnabled()) > 0;
	}

	public List<Employee> getAllEmployeeByName(String name) {
		return jdbcTemplate.query(SQL_GETALL_BY_NAME,  new Object[] {"%" + name + "%", "%" + name + "%",
				"%" + name + "%"}, new EmployeeMapper());
	}
	
	public Employee getAllEmployeeByEmail(String email){
		return jdbcTemplate.queryForObject(SQL_FIND_BY_EMAIL, new Object[] {email}, new EmployeeMapper());
	}
	
	public boolean updateEmployeePwd(String email, String pwd){
		return jdbcTemplate.update(SQL_UPDATE_PWD, pwd, email) > 0;
	}

}
