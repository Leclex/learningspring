package com.leclex.Spring.ch3.JDBC.dao;

import com.leclex.Spring.ch3.JDBC.model.Employee;

public interface EmployeeDao {
	public Employee getEmployeeById(int id);
	public void createEmployee();
	public void insertEmployee(Employee employee);
}
