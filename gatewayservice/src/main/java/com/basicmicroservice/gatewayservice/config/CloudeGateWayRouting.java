package com.basicmicroservice.gatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudeGateWayRouting {
    @Bean
    public RouteLocator configRoute(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route("paymentId", r -> r.path("/payment/**")
                        .uri("http://localhost:8060")) //static routing

                .route("ratelimiterId", r -> r.path("/limit/**")
                        .uri("http://localhost:8030")) //static routing
                .route("retryId", r -> r.path("/retry/**")
                        .uri("http://localhost:8020")) //static routing

                .route("orderId", r -> r.path("/order/**")
                        .uri("lb://orderservice") //dynamic routing
                )
                .build();
    }
}
