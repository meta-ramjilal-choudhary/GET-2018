package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.EmployeeDAO;
import com.metacube.training.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDAO employeeDAO;

	public Employee getEmployeeById(Long id) {
		return employeeDAO.getEmployeeById(id);
	}

	public List<Employee> getAllEmployee() {
		return employeeDAO.getAllEmployees();
	}

	public boolean deleteEmployee(Long id) {
		Employee employee = employeeDAO.getEmployeeById(id);
		return employeeDAO.deleteEmployee(employee);
	}

	public boolean updateEmployee(Employee employee) {
		return employeeDAO.updateEmployee(employee);
	}

	public boolean createEmployee(Employee employee) {
		return employeeDAO.createEmployee(employee);
	}

	public List<Employee> getAllEmployeeByName(String name) {
		return employeeDAO.getAllEmployeeByName(name);
	}
}
