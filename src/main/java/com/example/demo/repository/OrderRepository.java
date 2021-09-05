package com.example.demo.repository;

import com.example.demo.model.client.Order;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, ObjectId> {
    public Order findById(String orderId);
}
