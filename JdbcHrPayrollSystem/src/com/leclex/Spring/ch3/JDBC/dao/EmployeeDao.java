package com.leclex.Spring.ch3.JDBC.dao;

import com.leclex.Spring.ch3.JDBC.model.Employee;

public interface EmployeeDao {
	// get employee data based on employee id
	Employee getEmployeeById(int id);
	// create employee table
	void createEmployee();
	// insert values to employee table
	void insertEmployee(Employee employee);
}
