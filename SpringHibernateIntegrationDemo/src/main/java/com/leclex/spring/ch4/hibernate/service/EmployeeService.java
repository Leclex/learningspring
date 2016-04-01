package com.leclex.spring.ch4.hibernate.service;

import java.util.List;

import com.leclex.spring.ch4.hibernate.model.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();
	public void insertEmployee(Employee employee);
}
