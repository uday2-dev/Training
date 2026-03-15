package com.coforge.dao;

import java.security.interfaces.RSAKey;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.coforge.entities.Employee;



@Repository 
public abstract class EmployeeDao implements EmployeeDaoInterface {

    private final JdbcTemplate jdbcTemplate;
    public EmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @javax.annotation.PostConstruct
    public void init() {
        System.out.println("Employee Bean created, @PostConstruct called");
    }

    @javax.annotation.PreDestroy
    public void destroy() {
        System.out.println("Employee Bean destroyed, @PreDestroy called");
    }
    private static final RowMapper<Employee> EMPLOYEE_ROW_MAPPER = (rs, rowNum) -> {
        Employee employee = new Employee();
        employee.setEmpid(rs.getLong("empid"));
        employee.setEname(rs.getString("ename"));
        employee.setSalary(rs.getDouble("salary"));
        return employee;
    };

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "select * from employee";
        return jdbcTemplate.query(sql, EMPLOYEE_ROW_MAPPER);
    }

    @Override
    public void insertEmployee(Employee employee) {
        String sql = "insert into employee (empid, ename, salary) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, employee.getEmpid(), employee.getEname(), employee.getSalary());
    }

    @Override
    public Employee getEmployeebyId(long eid) {
        String sql = "select * from employee WHERE empid = ?";
        List<Employee> list = jdbcTemplate.query(sql, EMPLOYEE_ROW_MAPPER, eid);
        return list.isEmpty() ? null : list.get(0);
      
    }

    @Override
    public void updateEmployee(Employee employee) {
        String sql = "update employee set ename = ?, salary = ? WHERE empid = ?";
        jdbcTemplate.update(sql, employee.getEname(), employee.getSalary(), employee.getEmpid());
    }

    @Override
    public void deleteEmployee(Employee employee) {
        String sql = "delete from employee WHERE empid = ?";
        jdbcTemplate.update(sql, employee.getEmpid());
    }

	
}