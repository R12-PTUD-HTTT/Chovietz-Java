package com.chovietz.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.chovietz.model.Shop;


public interface ShopRepository extends MongoRepository<Shop, String>{

}
