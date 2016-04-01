package com.leclex.spring.ch5.mvc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.leclex.spring.ch5.mvc.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Employee> listEmployee() {
		Session session = sessionFactory.openSession();
		String hql = "from Employee";
		Query query = session.createQuery(hql);
		List<Employee> empList = query.list();
		logger.info("Person List::" + empList);
		return empList;
	}

	public void insertEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
	}

	public void deleteEmployee(Integer empId) {
		System.out.println("hql Using Delete");
		Session session = sessionFactory.openSession();
		String hql = "delete from Employee E where E.id = :employee_id";
		Query query = session.createQuery(hql);
		query.setParameter("employee_id", empId);
		int result = query.executeUpdate();
		System.out.println("Row affected: " + result);
	}

}
