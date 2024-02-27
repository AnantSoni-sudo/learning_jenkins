package com.practical.Customer_Management.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	
	private Long aadharNumber;
	
	@NotBlank(message = "Customer name should not be blank")
	private String customerName;
	
	@Min(value = 16 ,message = "Age should be equals to 16")
	@Max(value = 60, message = "Age should be at max 60")
	private Integer age;
	
	@Email(message = "Please enter the valid email format")
	@NotBlank(message = "Email field should not be blank")
	private String email;
	
	@Size(min = 10, max = 100, message = "Address should have a length between 10 and 100 characters.")
	private String customerAddress;
	
}
