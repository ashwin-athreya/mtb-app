package com.cg.mts.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@DynamicUpdate
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userid;
	//@NotBlank(message = "Username is required")
    //@Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
	private String username;
	//@NotBlank(message = "Password is required")
    //@Size(min = 6, message = "Password must be at least 6 characters")
	private String password;
	//@NotBlank(message = "Role is required")
    //@Pattern(regexp = "^(ADMIN||CUSTOMER)$", message = "Role must be ADMIN or CUSTOMER")
	private String role;
	@OneToOne
	private Customer customer;
	
	public User() {

	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User(String username, String password, String role, Customer customer) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.customer = customer;
		
	}
}
