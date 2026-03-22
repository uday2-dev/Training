//package com.example.controller;
//
//import java.net.URI;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.entities.Customer;
//import com.example.service.CustomerService;
//
//@RestController // combination of controller and response body
//public class CustomerContoller {
//	@Autowired
//	private CustomerService customerService;
//	
//	@GetMapping("/customer")   // requestmapping + get method
//	public ResponseEntity<List<Customer>> getAllCustomer()
//	{
//		try {
//			List<Customer> list = customerService.getAllCustomer();
//			if (list == null || list.isEmpty()) {
//				return ResponseEntity.noContent().build(); 
//			}
//			return ResponseEntity.ok(list); 
//		} catch (Exception e) {
//			// log if logging present
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
//		}
//	}
//	@PostMapping("/customer")
////	 combination of request mapping and method post
//	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer)
//	{
//		try {
//			Customer saved = customerService.saveCustomer(customer);
//			if (saved == null) {
//				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//			}
//			// return 201 Created with Location header if id available
//			try {
//				URI location = new URI("/customer/" + saved.getCid());
//				return ResponseEntity.created(location).body(saved);
//			} catch (Exception ex) {
//				return ResponseEntity.status(HttpStatus.CREATED).body(saved);
//			}
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//		}
//	}
//	@GetMapping("/customer/{cid}")
//	public ResponseEntity<Customer> getCustomerById(@PathVariable("cid") long cid)
//	{
//		try {
//			Customer c = customerService.getCustomerById(cid);
//			if (c == null) {
//				return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404
//			}
//			return ResponseEntity.ok(c);
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//		}
//	}
//	@PutMapping("/customer/{cid}")
//	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer,@PathVariable("cid") long cid)
//	{
//		try {
//			Customer updated = customerService.updateCustomer(customer, cid);
//			if (updated == null) {
//				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//			}
//			return ResponseEntity.ok(updated);
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//		}
//	}
//	@DeleteMapping("/customer/{cid}")
//	public ResponseEntity<Void> deleteCustomer(@PathVariable("cid") long cid)
//	{
//		try {
//			boolean deleted = false;
//			// If the service has void delete method that throws when not found,
//			// we call it and return 204 on success. Otherwise, check returned value.
//			try {
//				customerService.deleteCustomer(cid);
//				// assume success if no exception
//				return ResponseEntity.noContent().build(); // 204
//			} catch (RuntimeException re) {
//				// if service throws when entity not found
//				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//			}
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//		}
//	}
//	
//
//}


package com.example.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.service.annotation.GetExchange;
 
import com.example.entities.Customer;
import com.example.service.CustomerService;
//import com.coforge.service.CustomerServiceInterface;
 
@RestController
//it is the combo of component of Controller and response body
public class CustomerContoller {
	@Autowired
	private CustomerService service;
	@GetMapping("/customer")
	public  ResponseEntity<Customer> getAllCustomer() {
		return  new ResponseEntity(service.getAllCustomer(),HttpStatus.OK);
	}
	@PostMapping("/customer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<>(service.saveCustomer(customer),HttpStatus.CREATED);
	}
	@GetMapping("/customer?cid")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("cid")long cid){
		return new ResponseEntity<>(service.getCustomerById(cid),HttpStatus.OK);
		
	}
	@PutMapping("/customer/{cid}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer , @PathVariable("cid")long cid) {
		return new ResponseEntity<>( service.updateCustomer(customer, cid),HttpStatus.OK);
	}
	@DeleteMapping("/customer/{cid}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("cid") long cid) {
		service.deleteCustomer(cid);
		return new ResponseEntity<>("customerDeleted",HttpStatus.OK);
	}
	
 
}
 