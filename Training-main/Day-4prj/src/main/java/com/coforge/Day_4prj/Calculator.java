package com.coforge.Day_4prj;
// lamdas have a specific definations

public class Calculator {

//	@Override
//	public void add(int a, int b) {
//		System.out.println("sum : " + (a+b));
//		
//	}
	public static void main(String[] args) {
		// passing parameters to the lamda and no return
//		Calculatorinterface calculator = (a,b) -> System.out.println("Sum : " + (a+b));
//		calculator.add(23, 23);
		
		// passing parameters and having return
//		Calculatorinterface calculatorinterface = (a,b)->a-b;
//		System.out.println("Result :" +calculatorinterface.sub(10, 5));
		
		// i want to return the value but not pass the value
		
//		Calculatorinterface calculatorinterface = ()->{
//			int a = 6;
//			int b = 9;
//			return a * b;
//		};
//		System.out.println("Result " + calculatorinterface.mul());
		
		// now it will not have return type and values
		
		Calculatorinterface calculatorinterface = ()->{
			float a=72,b=4;
			System.out.println("Result " + a/b);
			
		};
		calculatorinterface.div();
	}
	

}
