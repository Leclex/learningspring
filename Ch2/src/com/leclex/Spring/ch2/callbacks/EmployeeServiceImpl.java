package com.leclex.Spring.ch2.callbacks;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class EmployeeServiceImpl implements EmployeeService, InitializingBean, DisposableBean {

	@Override
	public Long generateEmployeeID() {
		return System.currentTimeMillis();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Employee afterPropertiesSet...");
	}
	
	public void myInit() {
		System.out.println("Employee myInit...");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Employee destroy...");
	}
	
	public void cleanUp() {
		System.out.println("Employee Cleanup...");
	}

}
