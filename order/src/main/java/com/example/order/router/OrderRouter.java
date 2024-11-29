package com.example.order.router;

import com.example.order.handler.OrderHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class OrderRouter {
    @Autowired
    OrderHandler orderHandler;
    @Bean
    public RouterFunction<ServerResponse> route(){
    return RouterFunctions.route(
            RequestPredicates.GET("/order"), orderHandler::getAllOrders);
//            .andRoute(RequestPredicates.POST("/test"), userHandler::handlePost);
    }
}
