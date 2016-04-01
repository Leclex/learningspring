package com.leclex.spring.ch5.mvc.service;

import java.util.List;

import com.leclex.spring.ch5.mvc.model.Employee;

public interface EmployeeService {

	public List<Employee> listEmployee();

	public void insertEmployee(Employee employee);

	public void deleteEmployee(Integer empId);
}
