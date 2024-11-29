package com.example.order.service;

import com.example.order.model.Order;
import com.example.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.BooleanOperators;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public Mono<Order> saveOrder(Order order) {
       return orderRepository.save(order);
    }
    public Flux<Order> fetchInventory(){
        WebClient webClient = WebClient.create("http://localhost:8081");
        return webClient.get()
                .uri("/inventory")
                .accept(MediaType.ALL)
                .retrieve()
                .bodyToFlux(Order.class);
    }
}
