package com.coforge.Day_4prj;

// import java.rmi.server.RemoteStub;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Demoonbuiltfi {

	public static int main(String[] args) {
		
		// supplier 
		//consumer
		//function
		// predicate
		
		Supplier<String> strSupplier = ()->"Hello World".toUpperCase();
		System.out.println(strSupplier.get());
		
		Supplier<Double> randomSupplier=()->{
			double randomValue = Math.random();
			return randomValue;
			
		};
		System.out.println(randomSupplier.get());
		// we can use for it the otp supplier
		
		Supplier<Integer> otpSupplier=()->
		{
			Integer otpInteger = (int)(Math.random()*1000);
			return otpInteger;
		};
		System.out.println(otpSupplier.get());
		
//		Supplier<Integer[]>evenSupplier=()->{
//			for(int i=1;i<=10;i++)
//				if(i%2==0)
//					return i;
//		};
		
		// consumer 
		// it will accept but it will not return the value
		
		Consumer<String>strConsumer = (str1)-> System.out.println(str1.toUpperCase());
		strConsumer.accept("derrick");
		
		Consumer<Integer> squareConsumer = (num)->System.out.println(num*num);
		
		for(int i=0;i<=10;i++)
		{
			squareConsumer.accept(i);
		}
		//ex factorial of a number
		
		Consumer<Integer> factorialConsumer=(num)->{
			int fact = 1;
			for(int i=1;i<=num;i++)
				fact = fact*i;
			System.out.println(fact);
		};
		factorialConsumer.accept(5);
		
		
		// function
		// it have single abstract method apply
		// value which i supply , second para is a return value
		
		Function<Integer, Boolean>isEven = (num)->
		{
			if(num%2==0)
				return true;
			else
				return false;
		};
		System.out.println(isEven.apply(54));
			
		// use a functional interface and greet a message
		Function<String , String> greetFunction = (name)->
			"Hello "+name;
		System.out.println(greetFunction.apply("derrick"));
		
		// predicate
		// it have the test method as a abstract method
		
		Predicate<Integer> checkPredicate=(num)->num%2==0;
		if(checkPredicate.test(56))
			System.out.println("even number");
		else {
			System.out.println("odd number");
		}
		
		
		Predicate<String> checklengthPredicate = (str)->str.length()>5;
		System.out.println(checklengthPredicate.test("Derrick"));
		
		Predicate<String> authenPredicate=(uname)->uname.equals("derrick");
		Predicate<String> authenpassworePredicate=(pwd)->pwd.equals("derrick1234");
		
		String resultString = authenPredicate.test("derrick")&&authenpassworePredicate.test("derrick1234")?"passes":"invalid credentials";
		System.out.println(resultString);
		
		// validation
		// username length must be more than 3 chars
		// username can not be null
		// username cannot be blank
		
		Predicate<String> valuserPredicate = (uname)->uname.length()>3;
		Predicate<String> valueunamenull = (uname)->uname!=null && uname.isBlank();
		System.out.println(valuserPredicate.test("derrick"));
		return 0;
		
	}

}

// write down all the functional interfaces and its abstract methods.
