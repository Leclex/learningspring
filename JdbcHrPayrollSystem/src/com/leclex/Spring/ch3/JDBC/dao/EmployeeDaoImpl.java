package com.leclex.Spring.ch3.JDBC.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.leclex.Spring.ch3.JDBC.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = 
			"org.apache.derby.jdbc.ClientDriver";
	static final String DB_URL = "jdbc:derby://localhost:1527/db";
	
	private void registerDriver() {
		try {
			Class.forName(JDBC_DRIVER).newInstance();
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		} catch (ClassNotFoundException e) {
		}
	}

	@Override
	public Employee getEmployeeById(int id) {
		Connection conn = null;
		Employee employee = null;
		try {
			// register apache derby driver
			registerDriver();
			// open a connection useing DB url
			conn = DriverManager.getConnection(DB_URL);
			// creates a PrepareStatement object for sending parameterized SQL
			// statements to the database
			PreparedStatement ps = conn.prepareStatement("select * from employee where id = ?");
			// sets the designated parameters to the given Java int value
			ps.setInt(1, id);
			// executes the SQL query in this PreparedStatement object
			// and return the ResultSet object
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				employee = new Employee(id, rs.getString("name"));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {}
			}
		}
		return employee;
	}

	@Override
	public void createEmployee() {
		Connection conn = null;
		try {
			// register apache derby driver
			registerDriver();
			// open a connection using DB url
			conn = DriverManager.getConnection(DB_URL);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("create table employee (id integer, name char(30))");
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	@Override
	public void insertEmployee(Employee employee) {
		Connection conn = null;
		try {
			// register apache derby driver
			registerDriver();
			// open a connection using DB url
			conn = DriverManager.getConnection(DB_URL);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("insert into employee values ("
					+ employee.getId() + ",'" 
					+ employee.getName() + "')");
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
}
