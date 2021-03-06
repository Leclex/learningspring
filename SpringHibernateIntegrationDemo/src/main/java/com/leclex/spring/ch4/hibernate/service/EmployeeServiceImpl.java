package com.leclex.spring.ch4.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leclex.spring.ch4.hibernate.dao.EmployeeDao;
import com.leclex.spring.ch4.hibernate.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	public List<Employee> getAllEmployees() {
		List<Employee> emList = employeeDao.getAllEmployees();
		return emList;
	}

	public void insertEmployee(Employee employee) {
		employeeDao.insertEmployee(employee);
	}

}
