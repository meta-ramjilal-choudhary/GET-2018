package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Employee;
import com.metacube.training.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository<Employee> employeeRepository;

	public Employee getEmployeeById(Long id) {
		return employeeRepository.findOne(id);
	}

	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	public boolean deleteEmployee(Long id) {
		Employee employee = employeeRepository.findOne(id);
		employeeRepository.delete(employee);
		return true;
	}

	public boolean updateEmployee(Employee employee) {
		employeeRepository.save(employee);
		return true;
	}

	public boolean createEmployee(Employee employee) {
		employeeRepository.save(employee);
		return true;
	}

	public List<Employee> getAllEmployeeByName(String name) {
		return employeeRepository.findEmployeeByFirstName(name);
	}
}
