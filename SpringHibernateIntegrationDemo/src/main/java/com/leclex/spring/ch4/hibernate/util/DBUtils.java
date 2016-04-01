package com.leclex.spring.ch4.hibernate.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBUtils {

	@Autowired
	private DataSource dataSource;

	@PostConstruct
	public void initialize() {
		try {
			Connection connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			statement.execute("DROP TABLE IF EXISTS	employee_info");
			statement.executeUpdate("CREATE TABLE employee_info(id serial NOT NULL Primary key, "
					+ "first_name varchar(30) not null, last_name varchar(30) not null, "
					+ "job_title varchar(100) not null, department varchar(100) not null, salary INTEGER)");
			statement.executeUpdate("INSERT INTO employee_info (first_name, last_name, job_title, department, salary) "
					+ "VALUES ('ravi', 'soni', 'author', 'technology', 5000)");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
