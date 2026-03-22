package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.entities.Customer;

@Repository
public interface CustomerServiceInterface {
	public List<Customer>getAllCustomer();
	public Customer saveCustomer(Customer customer);
	public  Customer getCustomerById(long id);
	public Customer updateCustomer(Customer customer,long id);
	public void deleteCustomer(long id);

}
