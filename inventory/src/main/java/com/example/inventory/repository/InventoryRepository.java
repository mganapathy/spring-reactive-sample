package com.example.inventory.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.example.inventory.model.Order;

public interface InventoryRepository extends ReactiveMongoRepository<Order, Integer> {
}
