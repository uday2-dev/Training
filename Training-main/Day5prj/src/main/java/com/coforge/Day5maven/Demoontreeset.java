package com.coforge.Day5maven;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Demoontreeset {
	public static void main(String[]args)
	{
		TreeSet<Student> student = new TreeSet<Student>();
		
		Student s1 = new Student("nikku",234,90);
		Student s2 = new Student("priyanshu",23,80);
		Student s3 = new Student("priya",45,67);
		Student s4 = new Student("adarsh",432,23);
		Student s5 = new Student("zafar",245,67);
		Student s6 = new Student("bajapi",239,70);
		
		student.add(s1);
		student.add(s2);
		student.add(s3);
		student.add(s4);
		student.add(s5);
		student.add(s6);
		
		// when we work on the treeset always use the 
		// comparearable
		System.out.println(student);
		
		Iterator<Student> itr = student.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		itr = student.descendingIterator();
		while(itr.hasNext())
		System.out.println(itr.next());
		
		Set<Student> set = student.descendingSet();
		
		
		Student s7 = new Student("xyz",123,0);
		Student s8 = new Student("tyu",234,19);
		
		Set<Student> subset = student.subSet(s7, s8);
		
		System.out.println("subset of student tree");
		subset.forEach(e->System.out.println(e));
		
		System.out.println(student.ceiling(s8));
		System.out.println(student.floor(s8));
		System.out.println(student.higher(s8));
		System.out.println(student.lower(s8));
	}

}
