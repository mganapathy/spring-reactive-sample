package com.example.order.controller;

import com.example.order.model.Order;
import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping
    public  @ResponseBody Mono<Order> saveOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }
    @GetMapping("latestOrder")
    public  @ResponseBody Flux<Order> getAllInventoryOrders() {
        return orderService.fetchInventory();
    }
}
