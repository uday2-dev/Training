package com.coforge.Day6prj;

public class BankApp {

	public static void main(String[] args)throws InsufficentFundsException {
		Accountclass accountclass  = new Accountclass(1234567,"derrick","hyd",40000);
		accountclass.withdraw(2000);
		accountclass.withdraw(2000);
		accountclass.deposit(10000);
		

	}

}
