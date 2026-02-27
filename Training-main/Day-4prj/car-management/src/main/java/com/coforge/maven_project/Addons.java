package com.coforge.maven_project;

public interface Addons {
	public default void audiosystem() {
		System.out.println("Audio system with deafult 2 speakers");
	}
	public default void roofopen()
	{
		System.out.println("By default roof open disabled");
	}
	public static void warrantypolicy()
	{
		System.out.println("Warranty period : 3 years");
	}
	
}
