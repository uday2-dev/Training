package com.coforge.Day6prj;

import java.util.HashSet;
import java.util.Scanner;

public class Mainclass {
	static HashSet<Employee>hset= new HashSet<Employee>();
	static {
		// dummy database for the employees
		
		hset.add(new Employee(123,"xyz",456784));
		hset.add(new Employee(124,"the",456785));
		hset.add(new Employee(125,"you",456786));
		hset.add(new Employee(126,"qwe",456787));
		hset.add(new Employee(127,"asd",456788));
		hset.add(new Employee(128,"rty",456789));
	}
	public static void main(String[] args) {
		
		// Read operation
		hset.forEach(e->System.out.println(e));
		
		// create or insert
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter employee details");
		Employee employee = new Employee(sc.nextLong(),sc.next(),sc.nextDouble());
		hset.add(employee);
		
		// update
		System.out.println("enter the employee id for modification");
		long id = sc.nextLong();
		if(hset.contains(employee.getEmpid()))
		{
			
		}
		// delete 
		
		// use the functional interface to check the id inside it
		
		// this is assignment
		
		// make the menu driven for this like 1-update and so on for this class 
	}

}
