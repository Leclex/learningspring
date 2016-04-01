package com.leclex.Spring.ch3.JDBC.dao;

import java.util.List;

import com.leclex.Spring.ch3.JDBC.model.Employee;

public interface EmployeeDao {
	void createEmployee();
	int getEmployeeCount();
	void insertEmployee(final List<Employee> employees);
	int deleteEmployee(int empId);
	Employee getEmployeeById(int empId);
}
