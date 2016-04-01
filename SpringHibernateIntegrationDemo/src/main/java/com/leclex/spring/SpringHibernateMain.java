package com.leclex.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.leclex.spring.ch4.hibernate.model.Employee;
import com.leclex.spring.ch4.hibernate.service.EmployeeService;

public class SpringHibernateMain {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/app-context.xml");
		EmployeeService employeeService = context.getBean("employeeServiceImpl", EmployeeService.class);
		// insert employee
		Employee emp = new Employee();
		emp.setFirstName("Shree");
		emp.setLastName("Kant");
		emp.setJobTitle("Software Engineer");
		emp.setDepartment("Technology");
		emp.setSalary(3000);
		employeeService.insertEmployee(emp);
		// fetch all employee
		for (Employee employee : employeeService.getAllEmployees()) {
			System.out.println(employee);
		}
	}

}