package com.coforge.Day6prj;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Demoonmaps {
	public static void main(String[] args) {
		HashMap<Integer, String> hMap  = new HashMap<Integer, String>();
		hMap.put(1, "xyz");
		hMap.put(2, "xyzoo");
		hMap.put(3, "xyzii");
		System.out.println(hMap);
		
		for(Integer keyInteger : hMap.keySet())
		{
			System.out.println(keyInteger);
		}
		for(String vaString : hMap.values())
		{
			System.out.println(vaString);
		}
		
//		hMap.put(null, "amit");
//		System.out.println(hMap);
		// never give this otherwise it is not preferrable;
		
		System.out.println(hMap.containsKey(5));
		Set<Entry<Integer,String>> entryEntries=hMap.entrySet();
		
		Iterator<Entry<Integer, String>>itrIterator= entryEntries.iterator();
		while(itrIterator.hasNext())
		{
			System.out.println(itrIterator.next());
		}
		
		
		TreeMap<Integer, String> fruittreeMap = new TreeMap<Integer, String>();
		//it is a sorted map
		fruittreeMap.put(1, "derrick");
		fruittreeMap.put(2, "dhobhal");
		fruittreeMap.put(3, "pandey");
		fruittreeMap.put(4, "singhal");
		fruittreeMap.put(5, "nikku");
		fruittreeMap.put(6, "uday");
		
		System.out.println(fruittreeMap);
		// we cannot use the for each directly because it takes consumer and it only return
		// the one value so we cannot use it same goes with the hashmap
		// to make use of the for each we have to make the consumer of the entryset <1,2>;
		// same goes for it
		// 
	}

}
