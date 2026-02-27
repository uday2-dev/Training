package com.coforge.Day_4prj;

import java.util.Scanner;

public class Linearsearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = {1, 18, 15, 4, 7, 8, 9, 10, 12};
        System.out.println("enter the number you want to search");
        int key = sc.nextInt();

        boolean found = false;  
        for (int i = 0; i < arr.length; i++) {
            if (key == arr[i]) {
                System.out.println("found the element" +i);
                found = true;
                break; 
            }
        }

        if (!found) {
            System.out.println("not found");
        }

        
}
}