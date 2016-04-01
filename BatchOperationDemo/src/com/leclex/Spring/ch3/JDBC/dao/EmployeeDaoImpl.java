package com.leclex.Spring.ch3.JDBC.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.leclex.Spring.ch3.JDBC.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void createEmployee() {
		jdbcTemplate.execute("create table employee (EmpId integer, Name varchar(30), Age integer)");
	}

	@Override
	public int getEmployeeCount() {
		String sql = "select count(*) from employee";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public void insertEmployee(final List<Employee> employees) {
		jdbcTemplate.batchUpdate("insert into employee " 
	+ "(EmpId, Name, Age) values (?, ?, ?)", new BatchPreparedStatementSetter() {

		@Override
		public int getBatchSize() {
			return employees.size();
		}

		@Override
		public void setValues(PreparedStatement ps, int i) throws SQLException {
			Employee employee = employees.get(i);
			ps.setLong(1, employee.getEmpId());
			ps.setString(2, employee.getName());
			ps.setInt(3, employee.getAge());
		}
		
	});
		
	}

	@Override
	public int deleteEmployee(int empId) {
		String delQuery = "delete from employee where EmpId = ?";
		return jdbcTemplate.update(delQuery, new Object[] { empId });
	}

	@Override
	public Employee getEmployeeById(int empId) {
		String query = "select * from Employee where EmpId = ?";
		Employee employee = jdbcTemplate.queryForObject(query, new Object[] { empId },
				new RowMapper<Employee>() {

					@Override
					public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
						Employee employee = new Employee(rs.getInt("EmpId"), 
								rs.getString("Name"), rs.getInt("Age"));
						return employee;
					}
			
		});
		return employee;
	}

}
