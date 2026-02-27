package com.coforge.maven_project;

public class Cngcar extends Car implements Addons{

	@Override
	public void engineType() {
		System.out.println("This is a cng car");
		
	}
	@Override
	public void audiosystem()
	{
		System.out.println("only 2 woofers");
	}
	public Cngcar(String model) {
		super(model);
	}
	

}
