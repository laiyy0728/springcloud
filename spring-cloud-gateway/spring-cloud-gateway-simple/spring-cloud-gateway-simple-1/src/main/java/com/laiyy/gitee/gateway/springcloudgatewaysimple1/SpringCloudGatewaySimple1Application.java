package com.laiyy.gitee.gateway.springcloudgatewaysimple1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCloudGatewaySimple1Application {


    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes().route(r -> r.path("/jd")
                .uri("https://jd.com:80")
                .id("jd_route")
        ).build();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudGatewaySimple1Application.class, args);
    }

  }
