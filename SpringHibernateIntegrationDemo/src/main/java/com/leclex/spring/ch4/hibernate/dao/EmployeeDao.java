package com.leclex.spring.ch4.hibernate.dao;

import java.util.List;

import com.leclex.spring.ch4.hibernate.model.Employee;

public interface EmployeeDao {

	// to get all employees
	public List<Employee> getAllEmployees();
	// to insert new employee
	public void insertEmployee(Employee employee);
}
