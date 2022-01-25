package com.chovietz.repository;

import com.chovietz.model.ReturnOrder;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReturnOrderRepository extends MongoRepository<ReturnOrder, String>{
    
}
