package com.coforge.Day_4prj.Arrayday4;

public class Ranarray {
	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50};
        int position = 2;
        int element = 99;
 
        int[] newarr = new int[6];
        for(int i = 0; i < arr.length; i++) {
            newarr[i] = arr[i];
        }
        for(int i = newarr.length - 1; i > position; i--) {
            newarr[i] = newarr[i - 1];
        }
 
        newarr[position] = element;
        for(int num : newarr) {
            System.out.print(num + " ");
        }
	}

}
