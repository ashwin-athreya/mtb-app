package com.cg.mts.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	private String customerName;
	private String address;
	private String mobileNumber;
	private String email;
	private String password;

    public Customer(String customerName, String address, String mobileNumber, String email, String password) {
	         super();
	    this.customerName = customerName;
	    this.address = address;
	    this.mobileNumber = mobileNumber;
	    this.email = email;
	    this.password = password;
    }

}
