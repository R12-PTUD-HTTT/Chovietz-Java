package com.chovietz.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chovietz.model.Customer;
import com.chovietz.model.Order;
import com.chovietz.model.User;
import com.chovietz.repository.CustomerRepository;


@RestController
@RequestMapping("api/public/customer")
@CrossOrigin(origins= "*", maxAge=3600)
public class CustomerController {
	@Autowired
    private CustomerRepository customerRepository;
	
	@RequestMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> getUserInfo(@PathVariable("id") String id) {
		Optional<Customer> customer = customerRepository.findById(id);
		if (customer.isPresent()) {
			Customer _customer = customer.get();
			
			return new ResponseEntity<Customer>(_customer,HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}