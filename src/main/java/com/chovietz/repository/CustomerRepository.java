package com.chovietz.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.chovietz.model.Customer;


public interface CustomerRepository extends MongoRepository<Customer, String>{
	
}
