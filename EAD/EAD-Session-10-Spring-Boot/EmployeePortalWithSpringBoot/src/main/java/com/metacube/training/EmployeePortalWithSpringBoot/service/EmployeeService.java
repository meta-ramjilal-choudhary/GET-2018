package com.metacube.training.EmployeePortalWithSpringBoot.service;

import java.util.List;

import com.metacube.training.EmployeePortalWithSpringBoot.model.Employee;


public interface EmployeeService {

	Employee getEmployeeById(Long id);
	
	List<Employee> getAllEmployee();
	
	boolean deleteEmployee(Long id);
	
	boolean updateEmployee(Employee employee);
	
	boolean createEmployee(Employee employee);
	
	List<Employee> getAllEmployeeByName(String name);
	
	Employee getAllEmployeeByEmail(String email);
	
	boolean updateEmployeePwd(String email, String pwd);
}
