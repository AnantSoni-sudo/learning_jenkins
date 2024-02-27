package com.practical.Customer_Management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.practical.Customer_Management.entity.Customer;
import com.practical.Customer_Management.entity.CustomerErrorResponse;
import com.practical.Customer_Management.response.Response;

@ControllerAdvice
public class GenericExceptionHandler {

//	@ExceptionHandler
//	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc) {
//		// create a StudentErrorResponse
//		CustomerErrorResponse error = new CustomerErrorResponse();
//		error.setStatus(HttpStatus.NOT_FOUND.value());
//		error.setMessage(exc.getMessage());
//		error.setTimeStamp(System.currentTimeMillis());
//
//		// return StudentErrorResponse
//		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//	}
	@ExceptionHandler
	public ResponseEntity<Response<Customer>> handleException(CustomerNotFoundException exc) {
		Response<Customer> response = new Response<Customer>(true, exc.getMessage(), null);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<Response<Customer>> handleException(CustomerAlreadyExistsException exc) {
		Response<Customer> response = new Response<Customer>(true, exc.getMessage(), null);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); 
	}
}
