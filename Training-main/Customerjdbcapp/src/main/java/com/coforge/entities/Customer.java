package com.coforge.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
	private long custid;
	private String custname;
	private String address;
	private String email;
	private String mobile;
	
	

}

