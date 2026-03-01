package com.coforge.Day5maven;

import java.util.Enumeration;
import java.util.Vector;

public class Vectorrealted {
	// Demon Vectors
	// vector is a thread safe
	public static void main(String []args)
	{
		
	
	Vector <Integer> vector = new Vector<Integer>();
	System.out.println(vector.capacity());
	vector.add(23);
	vector.add(56);
	vector.add(1);
	vector.add(222);
	vector.add(56);
	vector.add(4);
	
	System.out.println(vector.capacity());
	
//	Enumeration<Integer> enums = vector.elements();
//	
//	while(enums.hasMoreElements())
//	{
//		System.out.println(enums.nextElement());
//		
//		
//	}
//	vector.trimToSize();
//	System.out.println(vector.size());
//	
//	System.out.println(vector.capacity());
//	
//	vector.add(2);
//	System.out.println(vector.capacity());
	vector.ensureCapacity(22);
	System.out.println(vector.capacity());
	
	System.out.println(vector.contains(2));
	System.out.println(vector.hashCode());
	System.out.println(vector.isEmpty());
	
	System.out.println(vector.subList(2, 4));
	
	
	// cpmpleted all the vector methods
	
	

	
	
	}

}
