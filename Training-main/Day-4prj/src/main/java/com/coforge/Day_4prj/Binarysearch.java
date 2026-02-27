package com.coforge.Day_4prj;

import java.util.Scanner;

public class Binarysearch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = {2,3,4,5,6,7,8,9,10,12,15,16,17,18,19,20,22,34,50};
		System.out.println("Enter a number to be searched");
		int key = sc.nextInt();
		
		int low=0;
		int high = arr.length - 1;
		while(low<high)
		{
		int mid = low + (high -low)/2;
		
		if(arr[mid]==key)
		{
			System.out.println("found at index" +mid);
			break;
		}
		else if(arr[mid]<key)
		{
			low = mid+1;
		}
		else {
			
				high=mid-1;
			
		}
		
		}
		if(low >= high)
			System.out.println("not found");
		
		
	}

}
