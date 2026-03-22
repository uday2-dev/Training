package com.example.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entities.Customer;
import com.example.repoistry.JPACustomerRepositry;

@Repository
public class CustomerDao implements Customerdaointerface {
	
	@Autowired
	private JPACustomerRepositry repositry;

	@Override
	public List<Customer> getAllCustomer() {
		return repositry.findAll();
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		
		return repositry.save(customer);
	}

	@Override
	public Optional<Customer> getCustomerById(long id) {
		
		return repositry.findById(id);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		
		return repositry.save(customer);
	}

	@Override
	public void deleteCustomer(long id) {
		repositry.deleteById(id);
		
	}

}
