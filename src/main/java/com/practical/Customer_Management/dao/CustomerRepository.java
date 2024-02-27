package com.practical.Customer_Management.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practical.Customer_Management.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

//	@Query("select c from Customer c order by c.customerName")
//	List<Customer> getAllSortedCustomerByName();
	
	@Query("select c from Customer c where c.aadharNumber=?1")
	Customer getCustomerByAadharNumber(Long aadharNumber);
}
