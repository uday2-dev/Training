package com.coforge.Day6prj;

public class Democlass {
	public static void calculate()
	{
		int a=5,b=0;
		if(b==0)
			throw new ArithmeticException();
		else {
			System.out.println(a/b);
		}
	}
public static void main(String[] args) {
	try {
		calculate();
	} catch (Exception e) {
		e.printStackTrace();
	}
	System.out.println("application recieved");
	
}
}
