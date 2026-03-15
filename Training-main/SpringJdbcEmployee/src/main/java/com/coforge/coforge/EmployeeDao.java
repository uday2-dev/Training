package com.coforge.coforge;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.coforge.dao.EmployeeDaoInterface;
import com.coforge.entities.Employee;
 
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
 
@Component
public abstract class EmployeeDao implements EmployeeDaoInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@PostConstruct
	public void init() {
		System.out.println("Employee dao bean created,postconstruct called");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("employee dao bean destroyed, destroy called");
		
	}
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		String query="select * from emp_id";
		RowMapper<Employee> rowMapper=(rs,rownum)->{
			Employee e=new Employee();
			e.setEmpid(rs.getLong("eid"));
			e.setEname(rs.getString("ename"));
			e.setSalary(rs.getDouble("salary"));
			return e;
	};
		return jdbcTemplate.query(query, rowMapper);
	}
 
	@Override
	public void insertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		String query="insert into emp_id(eid,ename,salary)values(?,?,?)";
		jdbcTemplate.update(query,employee.getEmpid(),employee.getEname(),employee.getSalary());
		System.out.println("row inserted");
	}
 
	@Override
	public Employee getEmployeebyId(long eid) {
		// Implement SELECT by id and map to Employee. Return null if not found.
		String query = "select * from emp_id where eid = ?";
		RowMapper<Employee> rowMapper = (rs, rowNum) -> {
			Employee e = new Employee();
			e.setEmpid(rs.getLong("eid"));
			e.setEname(rs.getString("ename"));
			e.setSalary(rs.getDouble("salary"));
			return e;
		};
		try {
			return jdbcTemplate.queryForObject(query, rowMapper, eid);
		} catch (EmptyResultDataAccessException ex) {
			// No employee found for given id
			return null;
		}
	}
 
	@Override
	public void updateEmployee(Employee employee) {
		String query = "update emp_id set ename = ?, salary = ? where eid = ?";
		int rows = jdbcTemplate.update(query, employee.getEname(), employee.getSalary(), employee.getEmpid());
		System.out.println("updateEmployee affected rows: " + rows);
	}
 
	@Override
	public void deleteEmployee(long eid) {
		String query = "delete from emp_id where eid = ?";
		int rows = jdbcTemplate.update(query, eid);
		System.out.println("deleteEmployee affected rows: " + rows);
	}

}