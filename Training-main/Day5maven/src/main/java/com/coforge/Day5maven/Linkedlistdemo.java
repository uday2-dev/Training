package com.coforge.Day5maven;

import java.util.Iterator;
import java.util.LinkedList;

public class Linkedlistdemo {
	public static void main(String[]args)
	{
		LinkedList<Integer>llist = new LinkedList<Integer>();
        llist.add(10);
        llist.add(20);
        llist.add(30);
//        System.out.println("After add(): "+llist);
//        llist.addFirst(5);
//        llist.addLast(40);
//        System.out.println("After addFirst & addLast: " +llist);
//        llist.add(2, 15);
//        System.out.println("After add at index 2: " +llist);
//        System.out.println("Element at index 3: " +llist.get(3));
//        System.out.println("First element: " +llist.getFirst());
//        System.out.println("Last element: " +llist.getLast());
//        llist.offer(50);
//        llist.offerFirst(1);
//        llist.offerLast(60);
//        System.out.println("After offer methods: " + llist);
//        System.out.println("Peek: " + llist.peek());
//        System.out.println("PeekFirst: " + llist.peekFirst());
//        System.out.println("PeekLast: " + llist.peekLast());
        
        //// -------------- todays assignments ----------------------------
        // question : linked list with the customers and do the sorting and all the stuffs
        // create employee linked list with 10 records
        // sort using Collection.sort on salary based
        // sort using the comparators, branch dept, name, salary
        //
        
        //// Descending iterator integerr
        
        Iterator<Integer> itr = llist.descendingIterator();
        while(itr.hasNext())
        {
        	System.out.println(itr.next());
        }
        
       
	}

}
