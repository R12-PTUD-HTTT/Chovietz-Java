package com.chovietz.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.chovietz.model.ShopApply;


public interface ShopApplyRepository extends MongoRepository<ShopApply, String>{
	@Query(value="{'id' : $0}", delete = true)
	public void deleteById (String id);
}
