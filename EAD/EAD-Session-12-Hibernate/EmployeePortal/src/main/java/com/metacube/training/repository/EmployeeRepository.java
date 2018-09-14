package com.metacube.training.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Employee;

@Repository
@Transactional
public interface EmployeeRepository<P> extends JpaRepository<Employee, Long>{

	@Query("from employee where fistName = :name")
	public List<Employee> findEmployeeByFirstName(@Param("name") String firstName);
}
