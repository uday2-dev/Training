package com.coforge.dao;
 
import java.util.List;
 
import com.coforge.entities.Employee;
 
public interface EmployeeDaoInterface {
 
	List<Employee> getAllEmployee();
	void insertEmployee(Employee employee);
	Employee getEmployeeById(long eid);
	
	// Add update and delete operations
	void updateEmployee(Employee employee);
	void deleteEmployee(long eid);
	List<Employee> getAllEmployees();
	Employee getEmployeebyId(long eid);
	void deleteEmployee(Employee employee);
	
}