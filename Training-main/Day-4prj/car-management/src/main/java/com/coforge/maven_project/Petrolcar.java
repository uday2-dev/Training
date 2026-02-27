package com.coforge.maven_project;

public class Petrolcar extends Car implements Addons {

	@Override
	public void engineType() {
		System.out.println("This is a petrol Engine.");
		
	}
	@Override 
	public void audiosystem()
	{
		System.out.println("Audio System is with speaker, woofers added");
	}
	public Petrolcar(String model) {
		super(model);
	}
	
	// make diesal car and cng car
	public void showwarranty()
	{
		Addons.warrantypolicy();
	}
	
	//Addons.warrantypolicy();
	

}
