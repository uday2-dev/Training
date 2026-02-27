package com.coforge.maven_project;

public abstract class Car implements Addons {
	private String model;

	public Car() {
		super();
	}

	public Car(String model) {
		super();
		this.model = model;
	}
	
	public abstract void  engineType();
	public void showmodel()
	{
		System.out.println("Model :"+this.model);
	}

	public void warrantypolicy() {
		
		Addons.warrantypolicy();
	}
	//Addons.warrantypolicy();

}
