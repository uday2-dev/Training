package com.example.repoistry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Customer;
@Repository
public interface JPACustomerRepositry extends JpaRepository<Customer, Long>{

	
	
}
