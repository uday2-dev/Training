package com.example.dao;

import java.util.List;
import java.util.Optional;

import com.example.entities.Customer;

public interface Customerdaointerface {
	public List<Customer>getAllCustomer();
	public Customer saveCustomer(Customer customer);
	public  Optional<Customer> getCustomerById(long id);
	public Customer updateCustomer(Customer customer);
	public void deleteCustomer(long id);
	
}
