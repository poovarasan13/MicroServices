package com.kce.order_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kce.order_service.entity.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order,String>{

}
