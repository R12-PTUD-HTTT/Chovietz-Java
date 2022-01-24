package com.chovietz.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.chovietz.model.Shop;


public interface ShopRepository extends MongoRepository<Shop, String>{
	@Query("{username:'?0'}")
	Shop findByUsername(String username);
}
