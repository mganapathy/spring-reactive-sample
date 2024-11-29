package com.example.order.handler;

import com.example.order.model.Order;
import com.example.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderHandler {
    @Autowired
    OrderRepository orderRepository;
    public Mono<ServerResponse> getAllOrders(ServerRequest request){
        Flux<Order> orderFlux = orderRepository.findAll();
        return ServerResponse.ok().body(orderFlux, Order.class);
    }
//    public Mono<ServerResponse> handlePost(ServerRequest request){
//        return request.bodyToMono(String.class).flatMap(body->ServerResponse.ok().bodyValue("router post method invoked"));
//    }
}
