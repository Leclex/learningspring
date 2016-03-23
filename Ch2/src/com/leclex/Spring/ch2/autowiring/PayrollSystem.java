package com.leclex.Spring.ch2.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PayrollSystem {

	public static void main(String[] args) {
		
		ApplicationContext context = new 
				ClassPathXmlApplicationContext("beans.xml");
		
		// retrieve for first time
		EmployeeService employeeServiceA = 
				(EmployeeService) context.getBean("employeeServiceBean");
		employeeServiceA.setMessage("Message by service A");
		
		System.out.println("employeeServiceA: " + employeeServiceA.getMessage());
		
		// retrieve it again
		EmployeeService employeeServiceB = 
				(EmployeeService) context.getBean("employeeServiceBean");
		System.out.println("employeeServiceB: " + employeeServiceB.getMessage());
		
		((ClassPathXmlApplicationContext)context).close();
	}

}
