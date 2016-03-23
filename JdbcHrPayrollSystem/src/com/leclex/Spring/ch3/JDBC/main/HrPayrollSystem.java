package com.leclex.Spring.ch3.JDBC.main;

import com.leclex.Spring.ch3.JDBC.dao.EmployeeDao;
import com.leclex.Spring.ch3.JDBC.dao.EmployeeDaoImpl;
import com.leclex.Spring.ch3.JDBC.model.Employee;

public class HrPayrollSystem {

	public static void main(String[] args) {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		// create employee table
		employeeDao.createEmployee();
		// insert into employee table
		employeeDao.insertEmployee(new Employee(1, "Ravi"));
		// get employee based on id
		Employee employee = employeeDao.getEmployeeById(1);
		System.out.println("Employee name: " + employee.getName());
	}

}
