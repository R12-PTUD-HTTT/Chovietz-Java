package com.chovietz.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.chovietz.model.ShopApply;


public interface ShopApplyRepository extends MongoRepository<ShopApply, String>{
	
}
