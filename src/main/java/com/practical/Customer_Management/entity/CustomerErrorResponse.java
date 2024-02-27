package com.practical.Customer_Management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerErrorResponse {

	private Integer status;
	private String message;
	private Long timeStamp;
	
	
}
