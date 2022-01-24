package com.chovietz.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.chovietz.model.Store;

public interface StoreRepository extends MongoRepository<Store, String>{

}
