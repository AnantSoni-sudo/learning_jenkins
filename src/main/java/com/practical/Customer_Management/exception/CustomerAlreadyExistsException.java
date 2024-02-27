package com.practical.Customer_Management.exception;

public class CustomerAlreadyExistsException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public CustomerAlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CustomerAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomerAlreadyExistsException(String message) {
		super(message);
	}

	
}
