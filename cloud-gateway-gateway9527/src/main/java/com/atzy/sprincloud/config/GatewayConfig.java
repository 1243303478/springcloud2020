package com.atzy.sprincloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
            routes.route("payment_route",r-> r.path("/get/**").uri("lb://CLOUD-PAYMENT-SERVICE")).build();
            routes.route("payment_route2",r-> r.path("/payment/lb/**").uri("lb://CLOUD-PAYMENT-SERVICE")).build();
            return routes.build();
    }
}
