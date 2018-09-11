package com.metacube.training.EmployeePortalWithSpringBoot.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.EmployeePortalWithSpringBoot.model.Employee;



public class EmployeeMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
		Employee employee = new Employee();
		employee.setEmp_code(resultSet.getLong("emp_code"));
		employee.setFirst_name(resultSet.getString("first_name"));
		employee.setMiddle_name(resultSet.getString("middle_name"));
		employee.setLast_name(resultSet.getString("last_name"));
		employee.setDob(resultSet.getDate("dob"));
		employee.setGender(resultSet.getString("gender"));
		employee.setPrimary_contact_no(resultSet.getString("primary_contact_no"));
		employee.setSecondary_contact_no(resultSet.getString("secondary_contact_no"));
		employee.setEmail_id(resultSet.getString("email_id"));
		employee.setSkype_id(resultSet.getString("skype_id"));
		employee.setProfile_picture(resultSet.getString("profile_picture"));
		employee.setPassword(resultSet.getString("password"));
		employee.setEnabled(resultSet.getBoolean("enabled"));
		return employee;
	}

}
