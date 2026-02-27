package com.coforge.maven_project;

public class Carmain {

	public static void main(String[] args) {
		 Car car = new Petrolcar("Swift");
		 car.engineType();
		 car.audiosystem();
		 car.showmodel();
		 car.warrantypolicy();
		 
		 car = new Cngcar("tiago");
		 car.audiosystem();
		 car.engineType();
		 car.showmodel();
		 
		 car = new Evcar("byd car");
		 car.audiosystem();
		 car.engineType();
		 car.showmodel();

	}

}
