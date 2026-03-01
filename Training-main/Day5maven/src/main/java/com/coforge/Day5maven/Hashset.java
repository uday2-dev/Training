package com.coforge.Day5maven;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.function.Predicate;

public class Hashset {
	public static void main(String [] args)
	{
		HashSet<Integer> hset = new HashSet<Integer>();
		hset.add(24);
		hset.add(90);
		hset.add(45);
		hset.add(67);
		hset.add(67);
		
		
		System.out.println(hset);
		
		for(Integer i:hset)
		{
			System.out.println(i);
		}
		// predicate takes a value and returns boolean value
		// it have test method
		
		Predicate<Integer>iseven = (e)->e%2==0;
		hset.removeIf(iseven);
		System.out.println(hset);
		
		// do the linked hashset
		LinkedHashSet<Integer> hseto = new LinkedHashSet<Integer>();
		hseto.add(24);
		hseto.add(25);
		hseto.add(26);
		hseto.add(27);
		hseto.add(28);
		
		for(Integer i:hseto)
		{
			System.out.println(i);
		}
		Predicate<Integer>iseven1 = (e)->e%2==0;
		hseto.removeIf(iseven1);
		System.out.println(hseto);
		
		Iterator<Integer>itr = hseto.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		
		// stacks, queue, dequeue,
		
		//------ treeset-----
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
