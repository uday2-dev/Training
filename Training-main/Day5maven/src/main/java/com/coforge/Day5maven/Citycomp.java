package com.coforge.Day5maven;

import java.util.Comparator;

public class Citycomp implements Comparator<Customer> 
{

	@Override
	public int compare(Customer o1, Customer o2) {
		return o1.getCity().compareTo(o2.getCity());
	}

}
