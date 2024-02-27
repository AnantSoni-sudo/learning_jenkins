package com.practical.Customer_Management.rest;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practical.Customer_Management.entity.Customer;
import com.practical.Customer_Management.entity.CustomerErrorResponse;
import com.practical.Customer_Management.exception.CustomerAlreadyExistsException;
import com.practical.Customer_Management.exception.CustomerNotFoundException;
import com.practical.Customer_Management.service.ICustomerService;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("api/v1")
public class CustomerRestController {

	@Autowired
	private ICustomerService customerService;
	
	/*
	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer customer) {
//		customer.setCustomerId(0);
		customerService.save(customer);
		return customer;
	}
	*/
	
	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer customer) {
		List<Customer> list = customerService.getAll();
		List<Long> aadharNo = list.stream().map(x -> x.getAadharNumber()).collect(Collectors.toList());
		if(aadharNo.contains(customer.getAadharNumber())) {
			throw new CustomerAlreadyExistsException(customer + " customer is already exists");
		} else {
			customerService.save(customer);
			return customer;
		}
	}
	
	@PutMapping("/updatecustomer")
	public Customer updateCustomerById(@RequestBody Customer customer) {
		customerService.save(customer);
		return customer;
	}
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomer() {
		return customerService.getAll();
	}
	
	@GetMapping("/customer/{customerId}")
	public Customer getCustomerById(@PathVariable Integer customerId) {
		Optional<Customer> optional = customerService.getCustomerById(customerId);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			throw new CustomerNotFoundException("Customer is not found");
		}
	}
	
	@DeleteMapping("/removecustomer/{customerId}")
	public String deleteById(@PathVariable Integer customerId) {
		Optional<Customer> optional = customerService.getCustomerById(customerId);
		if(optional.isPresent()) {
			customerService.deleteById(customerId);
			return "The Customer with ID " + customerId + " has been deleted";
		} else {
			throw new CustomerNotFoundException("Customer is not available to perform delete operation");
		}
	}
	
//	@GetMapping("/sortname")
//	public List<Customer> getAllSortedCustomerByName() {
//		return customerService.getAllSortedCustomerByName();
//	}
	
	@GetMapping("/sortname")
	public List<Customer> getSortedCustomerByName() {
		return customerService.getSortedCustomerByName();
	}
	
	@GetMapping("/totalcustomers") 
	public Long getTotalCustomer() {
		return customerService.getTotalCustomer();
	}
	
	@GetMapping("/customerbyan/{aadharNumber}")
	public Customer getCustomerByAadharNumber(@PathVariable Long aadharNumber) {
		return customerService.getCustomerByAadharNumber(aadharNumber);
	}
	
}
