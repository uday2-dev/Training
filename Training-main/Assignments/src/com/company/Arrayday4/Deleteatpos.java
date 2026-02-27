package com.coforge.Day_4prj.Arrayday4;

public class Deleteatpos {
	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50};
        int index = 2;
 
        int[] newarr = new int[arr.length - 1];
 
        for(int i = 0, j = 0; i < arr.length; i++) {
            if(i != index) {
                newarr[j] = arr[i];
                j++;
            }
        }
 
        for(int num : newarr) {
            System.out.print(num + " ");
        }
	}

}
