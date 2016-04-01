package com.leclex.Spring.ch3.JDBC.dao;

import com.leclex.Spring.ch3.JDBC.model.Employee;

public interface EmployeeDao {
	void createEmployee();
	int getEmployeeCount();
	int insertEmployee(Employee employee);
	int deleteEmployee(int empId);
	Employee getEmployeeById(int empId);
}
