package com.coforge.Day6prj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Accountclass {
	private long accountnumber;
	private String name;
	private String branchname;
	private double balance;
	
	public void withdraw(double amount) throws InsufficentFundsException
	{
		if(amount <= this.balance)
		{
			this.balance-=amount;
			System.out.println("withdrawal successful");
		}
		else {
			
				throw new InsufficentFundsException();
			
		}
	}
	public void deposit(double amount)
	{
		this.balance+=amount;
		System.out.println("deposit successful");
	}

}
