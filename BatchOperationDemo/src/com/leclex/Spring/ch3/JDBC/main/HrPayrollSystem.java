package com.leclex.Spring.ch3.JDBC.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.leclex.Spring.ch3.JDBC.dao.EmployeeDao;
import com.leclex.Spring.ch3.JDBC.model.Employee;

public class HrPayrollSystem {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		EmployeeDao employeeDao = context.getBean("employeeDaoImpl", EmployeeDao.class);
		employeeDao.createEmployee();
		List<Employee> employeeList = new ArrayList<>();
		Employee employee1 = new Employee(10001, "John", 28);
		Employee employee2 = new Employee(23330, "Kant", 23);
		Employee employee3 = new Employee(12568, "Soni", 26);
		employeeList.add(employee1);
		employeeList.add(employee2);
		employeeList.add(employee3);
		employeeDao.insertEmployee(employeeList);
		Employee employee = employeeDao.getEmployeeById(10001);
		System.out.println("Employee name: " + employee.getName());
		System.out.println(employeeDao.getEmployeeCount());
		((ClassPathXmlApplicationContext)context).close();
	}

}
