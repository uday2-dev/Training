package com.coforge.Day5maven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Coustomermain {

	public static void main(String[] args) {
		Customer c1 = new Customer(1,"derrick","hyd",56000);
		Customer c2 = new Customer(2,"amit","blr",6000);
		Customer c3 = new Customer(3,"ram","chennai",78000);
		Customer c4 = new Customer(4,"raju","pune",9000);
		Customer c5 = new Customer(5,"priyanshu","up",600);
		Customer c6 = new Customer(6,"priya","hyd",47000);
		Customer c7 = new Customer(7,"bajpai","mumbai",98000);
		
		ArrayList<Customer> cust = new ArrayList<Customer>();
		cust.add(c1);
		cust.add(c2);
		cust.add(c3);
		cust.add(c4);
		cust.add(c5);
		cust.add(c6);
		cust.add(c7);
		
		//Collections.sort(cust); // it only work in the wrapper classes like integer, string same type of data
//		Wrapper classes (Integer, Double, etc.)
//
//		String
//
//		Any custom class that implements Comparable
		cust.sort(new Ordercostcomp().thenComparing(new Citycomp()));
		cust.forEach(custi->System.out.println(custi));
		
		
	}

	
}
