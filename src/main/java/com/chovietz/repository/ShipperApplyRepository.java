package com.chovietz.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.chovietz.model.ShipperApply;


public interface ShipperApplyRepository extends MongoRepository<ShipperApply, String>{
	@Query(value="{'id' : $0}", delete = true)
	public void deleteById (String id);
}
