package com.coforge.Day_4prj.Arrayday4;

public class Insertatpos {

	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50};
        int position = 2;  
        int element = 99;
 
        int[] newarr = new int[arr.length + 1];
        for(int i = 0; i < position; i++) {
            newarr[i] = arr[i];
        }
        newarr[position] = element;
        for(int i = position; i < arr.length; i++) {
            newarr[i + 1] = arr[i];
        }
        for(int num : newarr) {
            System.out.print(num + " ");

	}

}

}