package com.cg.mts.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.dto.CustomerDTO;
import com.cg.mts.entity.Customer;
import com.cg.mts.exception.AccessForbiddenException;
import com.cg.mts.exception.CustomerNotFoundException;
import com.cg.mts.mapper.EntityDtoMapper;
import com.cg.mts.service.CustomerService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/customer")
public class CustomerController {

	Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;
	@Autowired
	LoginController loginController;

	
	@PostMapping("/add")
	public ResponseEntity<String> addCustomer(@Valid @RequestBody CustomerDTO customerDTO)
			throws CustomerNotFoundException, AccessForbiddenException {
	
		ResponseEntity<String> response = null;
		Customer customer=EntityDtoMapper.convertToEntity(customerDTO, Customer.class);
		if (customer == null) {
			logger.error("-------------Please Enter Customer Values--------");
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			customer = customerService.addCustomer(customer);
			response = new ResponseEntity<>("Customer is Added", HttpStatus.CREATED);
			logger.info("----------------Customer Created------------------");
		}
		return response;
	}

	
	@PutMapping("/update")
	public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO)
			throws CustomerNotFoundException, AccessForbiddenException {
		
		ResponseEntity<CustomerDTO> response = null;
		Customer customer=EntityDtoMapper.convertToEntity(customerDTO, Customer.class);
		if (customer == null) {
			logger.error("Enter Customer Details");
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			customer = customerService.updateCustomer(customer);
			CustomerDTO resultDTO=EntityDtoMapper.convertToDTO(customer, CustomerDTO.class);
			response = new ResponseEntity<>(resultDTO, HttpStatus.OK);
			logger.info("--------------Customer Updated Successfully-----------------");
		}
		return response;
	}

	

	
	
}
