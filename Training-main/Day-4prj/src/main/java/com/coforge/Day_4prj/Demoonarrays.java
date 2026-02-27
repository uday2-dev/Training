package com.coforge.Day_4prj;

import java.util.Scanner;

public class Demoonarrays {
	public static void main(String[] args) {
		int arr[]=new int[5];
		Scanner sc = new Scanner(System.in);
		System.out.println("enter numbers");
		int sum=0;
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = sc.nextInt();
		}
		for(int i=0;i<arr.length;i++)
		{
			sum = sum + arr[i];
			
		}
		System.out.println(sum);
		
	}
	
	
}
// sum of array elements
// search an element -- linear and binary
// sort elements -- bubble, selection, insertion,quicksort, merge sort
// insert an element at a given position
// delete an element at a given position
//  assume an array lengthis 5 try to insert to 6 element
