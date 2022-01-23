package com.chovietz.repository;
import com.chovietz.model.Shipper;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShipperRepository extends MongoRepository<Shipper, String>{
    
}
