package com.coforge.maven_project;

public class Evcar extends Car implements Addons {

	@Override
	public void engineType() {
		System.out.println("This is a evcar");
		
		
	}
	@Override
	public void audiosystem()
	{
		System.out.println("only with 1 woofer");
	}
	public Evcar(String model) {
		super(model);
	}
	
	

}
