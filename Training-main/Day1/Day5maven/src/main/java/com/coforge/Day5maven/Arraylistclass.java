package com.coforge.Day5maven;
import java.util.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Arraylistclass {

	public static void main(String[] args) {
//		ArrayList alist = new ArrayList();
//		alist.add("derrick");
//		alist.add(34); // wrapped by wrapper class integer
//		alist.add(true);
//		alist.add('5');
//		
//		for(int i=0; i< alist.size();i++)
//		{
//			System.out.println(alist.get(i));
//		}
//		alist.add("derrick");
//		alist.add(34); // wrapped by wrapper class integer
//		alist.add(true);
//		alist.add('5');
//		
//		for(int i=0; i< alist.size();i++)
//		{
//			System.out.println(alist.get(i));
//		}
//		alist.add(null);
//		alist.add(null);
		
		
		ArrayList<Integer> intalist = new ArrayList<Integer>();
		intalist.add(5);
		intalist.add(6);
		intalist.add(100);
		intalist.add(100);
		intalist.add(100);
		intalist.add(100);
		intalist.add(100);
//		System.out.print(intalist);
//		for(int i=0;i<intalist.size();i++)
//		{
//			System.out.print(intalist.get(i));
//		}
//		for(int i : intalist)
//		{
//			System.out.println(i);
//		}
		
		// if i go with the capital Integer in for each loop we can print null because it acts as
		// a object so null is a object value and can print it , but it is not possible with int it will 
		// give the null pointer exception
//		Integer iobj = null;
//		int i1 = iobj.intValue(); 
		
		
		//// iterators
		/// it can go to concurrent execution
		/// enum have symbolic constants.. enumeration is possible on the collection
		/// 
		
//		Iterator<Integer>itr = intalist.iterator();
//		while(itr.hasNext())
//		{
//			// itr.remove
//			System.out.println(itr.next());
//		}
		
//		System.out.println("forward directions");
//		ListIterator<Integer> itr = intalist.listIterator();
//		// it is used to come and back in list 
//		// but do not come back in the vry first operations
//		// we have to perform the first hasnext and then hasprevious we cannot do 
//		// directly to at last position of arraylist
//		
//		
//		while(itr.hasNext())
//		{
//			System.out.println(itr.next());
//		}
//		
//		System.out.println("reverse directio of lisyt values");
//		while(itr.hasPrevious())
//		{
//			System.out.println(itr.previous());
//		}
		ArrayList<Integer> intalist1 = new ArrayList<Integer>();
//		intalist1.add(5);
//		intalist1.add(6);
//		intalist1.add(100);
//		intalist1.add(100);
//		intalist1.add(100);
//		intalist1.add(100);
//		intalist1.add(100);
		
		intalist1.addAll(intalist);
		System.out.println(intalist1);
//		intalist1.removeAll(intalist);
//		
//		intalist.replaceAll(e->e+10);
//		System.out.println(intalist);
//		System.out.println(intalist);
//		intalist.clear();
//		System.out.println(intalist);
		
		intalist.addFirst(76);
		System.out.println(intalist); 
		
		
//		ArrayList<Integer> clonearray = (ArrayList<Integer>) intalist.clone();
//		System.out.println(clonearray);
//		
//		System.out.println(intalist.hashCode());
//		System.out.println(clonearray.hashCode());
//		
////		clonearray.add(78);
//		intalist.add(67);
//		System.out.println(intalist);
//		System.out.println(clonearray);
//		
//		System.out.println(intalist.hashCode());
//		System.out.println(clonearray.hashCode());
//		
//		// serializable interface is marker 
//		
//		System.out.println(intalist.contains(6));
//		System.out.println(intalist.containsAll(intalist1));
		
		intalist.forEach(e->System.out.println(e));
		System.out.println(intalist.indexOf(5));
		
		// retains will get the common elements
		intalist.retainAll(intalist1);
		System.out.println(intalist);
		
		//List<Integer>ar = new List<Integer>intalist.reversed();
		//System.out.println(intalist);
		
		Collections.sort(intalist);
		System.out.println(intalist);
		
		intalist.toArray();
		
		Integer[] irr = intalist.toArray(new Integer[0]);
		
		Integer[] arr  = {334,56,32,43,87};
		List<Integer>list = Arrays.asList(arr);
		// we cannot do direclty we have to do using arrays utlity class.
		// complete stack and its methods also
		
		
	}

}
