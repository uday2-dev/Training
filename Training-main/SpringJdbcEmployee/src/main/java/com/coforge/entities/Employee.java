package com.coforge.entities;
 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@AllArgsConstructor
@NoArgsConstructor
@Data
 
public class Employee {
	private long empid;
	private String ename;
	private  double salary;
    public Employee(double salary){
    	super();
    	this.salary=salary;
    }
}