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
		
//		// Read operation
//		hset.forEach(e->System.out.println(e));
//		
//		// create or insert
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("enter employee details");
//		Employee employee = new Employee(sc.nextLong(),sc.next(),sc.nextDouble());
//		hset.add(employee);
//		
//		// update
//		System.out.println("enter the employee id for modification");
//		long id = sc.nextLong();
//		if(hset.contains(employee.getEmpid()))
//		{
//			
//		}
//		// delete 
//		
//		// use the functional interface to check the id inside it
//		
//		// this is assignment
//		// crud operation
//		// make the menu driven for this like 1-update and so on for this class 
		System.out.println("Menu driven");
		
		Scanner sc= new Scanner(System.in);
		
		while(true)
		{
			System.out.println(" 1 Read the data");
			System.out.println(" 2 Create the data");
			System.out.println("3 Update the data");
			System.out.println("4  Delete the data");
			System.out.println("enter choice");
			
			int ch = sc.nextInt();
			
			switch(ch)
			{
			case 1 :
				hset.forEach(e->System.out.println(e));
				break;
			case 2 :
				System.out.println("enter details");
				Employee employee = new Employee(sc.nextLong(),sc.next(),sc.nextDouble());
				break;
			case 3:
				System.out.println("enter detail to update");
				long id = sc.nextLong();
				
				for(Employee e:hset)
				{
					if(e.getEmpid() == id)
					{
						System.out.println("enter name");
						e.setEmpname(sc.next());
						System.out.println("enter salary");
						e.setSalary(sc.nextDouble());
						break;
						
					}
				}
			case 4:
				System.out.println("enter id to delete");
				long idtodelete = sc.nextLong();
				for(Employee employee2 : hset)
				{
					if(employee2.getEmpid() == idtodelete)
					{
						hset.remove(employee2);
					}
				}
				
			default:
				System.out.println("wrong choice");
				
				
				
				
			}
		}
		
		
		
		
	}

}
