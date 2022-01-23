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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chovietz.model.Customer;
import com.chovietz.model.Order;
import com.chovietz.model.User;
import com.chovietz.payload.ChangepassReq;
import com.chovietz.payload.MessageRes;
import com.chovietz.repository.CustomerRepository;

import lombok.extern.java.Log;


@RestController
@RequestMapping("api/user/customer")
@CrossOrigin(origins= "*", maxAge=3600)
public class CustomerController {
	@Autowired
    private CustomerRepository customerRepository;
	
    @Autowired
    PasswordEncoder encoder;
	
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
	@PutMapping("/{id}")
	public ResponseEntity<Customer> updateInfo(@PathVariable("id") String id, @RequestBody Customer request) {
		Optional<Customer> cusData = customerRepository.findById(id);
		if (cusData.isPresent()) {
			Customer _cus = cusData.get();
			_cus.setName(request.getName());
			_cus.setGender(request.getGender());
			_cus.setDate_of_birth(request.getDate_of_birth());
			_cus.setPhoneNumber(request.getPhoneNumber());
			_cus.setEmail(request.getEmail());
			return new ResponseEntity<>(customerRepository.save(_cus), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/changepass/{id}")
	public ResponseEntity<?> changePass(@PathVariable("id") String id, @RequestBody ChangepassReq request) {
		Optional<Customer> cusData = customerRepository.findById(id);
		if (cusData.isPresent()) {
			Customer _cus = cusData.get();
		
			if(encoder.matches(request.getCurrent(), _cus.getPassword())) {
				if(request.getNewpass().equals(request.getComfirm())) {
					_cus.setPassword(encoder.encode(request.getNewpass()));
					return new ResponseEntity<>(customerRepository.save(_cus), HttpStatus.OK);
				}
				else {
					return new ResponseEntity<>(new MessageRes("Mật khẩu xác nhận không trùng khớp"),HttpStatus.NOT_FOUND);
				}
			}
			else {
				return new ResponseEntity<>(new MessageRes("Mật khẩu hiện tại không trùng khớp"),HttpStatus.NOT_FOUND);
			}
			
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
