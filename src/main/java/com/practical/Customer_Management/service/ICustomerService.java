package com.practical.Customer_Management.service;

import java.util.List;
import java.util.Optional;

import com.practical.Customer_Management.entity.Customer;

public interface ICustomerService {

	public void save(Customer customer);
	
	public List<Customer> getAll();
	
	public void deleteById(Integer customerId);
	
	public Optional<Customer> getCustomerById(Integer customerId);
	
//	public List<Customer> getAllSortedCustomerByName();
	
	public List<Customer> getSortedCustomerByName();
	
	public Long getTotalCustomer();
	
	public Customer getCustomerByAadharNumber(Long aadaharNumber);
	
}
