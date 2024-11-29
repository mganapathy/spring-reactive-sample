package com.example.inventory.controller;

import com.example.inventory.model.Order;
import com.example.inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    InventoryRepository inventoryRepository;

    @GetMapping
    public  @ResponseBody Flux<Order> getInventoryOrder() {
        return inventoryRepository.findAll();
    }
    @PostMapping
    public @ResponseBody Mono<Order> saveOrder(@RequestBody Order order){
        return inventoryRepository.save(order);
    }
}
