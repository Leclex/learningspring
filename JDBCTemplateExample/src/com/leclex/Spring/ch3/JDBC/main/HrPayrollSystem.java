package com.leclex.Spring.ch3.JDBC.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.leclex.Spring.ch3.JDBC.dao.EmployeeDao;
import com.leclex.Spring.ch3.JDBC.model.Employee;

public class HrPayrollSystem {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		EmployeeDao employeeDao = context.getBean("employeeDaoImpl", EmployeeDao.class);
		employeeDao.createEmployee();
		employeeDao.insertEmployee(new Employee(1, "Ravi", 28));
		Employee employee = employeeDao.getEmployeeById(1);
		System.out.println("Employee name: " + employee.getName());
		((ClassPathXmlApplicationContext)context).close();
	}

}
