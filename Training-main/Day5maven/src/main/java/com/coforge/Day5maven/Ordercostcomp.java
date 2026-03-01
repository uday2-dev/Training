package com.coforge.Day5maven;


import java.util.Comparator;

public class Ordercostcomp implements Comparator<Customer>{

	@Override
	public int compare(Customer o1, Customer o2) {
		
		return (int)( o1.getOrdercost()-o2.getOrdercost());
	}

}
