package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CustomerDao;
import com.example.entities.Customer;

@Service
public class CustomerService implements CustomerServiceInterface{

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public List<Customer> getAllCustomer() {
		
		return customerDao.getAllCustomer();
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		
		return customerDao.saveCustomer(customer);
	}

	@Override
	public Customer getCustomerById(long id) {
		return customerDao.getCustomerById(id).orElseThrow(()->new RuntimeException());
	}

	@Override
	public Customer updateCustomer(Customer customer, long id) {
		Customer exCustomer = customerDao.getCustomerById(id).orElseThrow();
		
			if(exCustomer!=null)
			{
				exCustomer.setCname(customer.getCname());
				exCustomer.setAddres(customer.getAddres());
				exCustomer.setMobile(customer.getMobile());
				return customerDao.saveCustomer(exCustomer);
			}
		return null;
		
		
	}

	@Override
	public void deleteCustomer(long id) {
		
		Customer exCustomer = customerDao.getCustomerById(id).orElseThrow(()->new RuntimeException());
		
	
			customerDao.deleteCustomer(id);
		   System.out.println("Customer Deleted Successfully");
		
			//System.out.println("not present");
		
		
		
	}
	

}
