package com.practical.Customer_Management.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {

	{
		System.out.println("Change");
	}
	
	private boolean error;
	private String message;
	T data;
	
}
