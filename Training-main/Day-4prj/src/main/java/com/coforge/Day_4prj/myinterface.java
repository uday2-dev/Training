package com.coforge.Day_4prj;
@FunctionalInterface // only one single abstract method is there
public interface myinterface {
	
	public void display();
	public default void printdetails()
	{
		System.out.println("default method of my interface invoke");
	}
	public static void useparking(String compname)
	{
		System.out.println(compname + "using parking area");
	}
	
	

}
