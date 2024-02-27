package com.practical.Customer_Management.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practical.Customer_Management.dao.CustomerRepository;
import com.practical.Customer_Management.entity.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public void save(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAll() {
		return customerRepository.findAll();
	}

	@Override
	public void deleteById(Integer customerId) {
		customerRepository.deleteById(customerId);
	}

	@Override
	public Optional<Customer> getCustomerById(Integer customerId) {
		return customerRepository.findById(customerId);
	}


//	@Override
//	public List<Customer> getAllSortedCustomerByName() {
//		return customerRepository.getAllSortedCustomerByName();
//	}


	@Override
	public List<Customer> getSortedCustomerByName() {
		List<Customer> list = customerRepository.findAll();
		List<Customer> sortedListByName = list.stream().sorted((x, y) -> x.getCustomerName().compareTo(y.getCustomerName())).collect(Collectors.toList());
		return sortedListByName;
	}

	@Override
	public Long getTotalCustomer() {
		List<Customer> list = customerRepository.findAll();
		Long count = list.stream().count();
		return count;
	}

	@Override
	public Customer getCustomerByAadharNumber(Long aadaharNumber) {
		return customerRepository.getCustomerByAadharNumber(aadaharNumber);
	}
}
