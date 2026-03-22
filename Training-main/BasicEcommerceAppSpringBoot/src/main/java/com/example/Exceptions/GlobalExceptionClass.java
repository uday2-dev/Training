package com.example.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.entities.Customer;

@ControllerAdvice
public class GlobalExceptionClass {
	
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> handleCustomerNotFoundException(CustomerNotFoundException e){
		return new ResponseEntity<>("Customer Not found",HttpStatus.NOT_FOUND);
	}
	
	
	

}