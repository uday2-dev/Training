package com.coforge.beans;

public class Hellobeans {
	private String name;
	
	public Hellobeans(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Hellobeans [name=" + name + "]";
	}

	public Hellobeans() {
		super();
	}

	public void printname()
	{
		System.out.println(this.name);
	}

	public void sayhello()
	{
		System.out.println("say hello");
	}

	

}
