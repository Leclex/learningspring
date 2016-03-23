package com.leclex.Spring.ch2.autowiring;

import org.springframework.beans.factory.InitializingBean;

public class EmployeeServiceImpl implements EmployeeService {
//	private EmployeeDao employeeDao;
//	
//	public EmployeeServiceImpl(EmployeeDao employeeDao) {
//		this.employeeDao = employeeDao;
//	}
//	
//	public EmployeeDao getEmployeeDao() {
//		return employeeDao;
//	}
//	
//	public void setEmployeeDao(EmployeeDao employeeDao) {
//		this.employeeDao = employeeDao;
//	}
	
	private String message;
	
	@Override
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
}
