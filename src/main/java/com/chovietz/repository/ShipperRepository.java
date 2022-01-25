package com.chovietz.repository;
import com.chovietz.model.Shipper;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ShipperRepository extends MongoRepository<Shipper, String>{
	@Query("{username:'?0'}")
	Shipper findByUsername(String username);
}
