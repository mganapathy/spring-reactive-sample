package com.example.order.repository;

import com.example.order.model.Order;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface OrderRepository extends ReactiveMongoRepository<Order, Integer> {
}
