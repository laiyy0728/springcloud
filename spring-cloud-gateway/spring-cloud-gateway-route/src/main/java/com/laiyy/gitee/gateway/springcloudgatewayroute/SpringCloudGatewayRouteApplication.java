package com.laiyy.gitee.gateway.springcloudgatewayroute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@SpringBootApplication
public class SpringCloudGatewayRouteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudGatewayRouteApplication.class, args);
    }

//    between
    @Bean
    public RouteLocator afterRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        ZonedDateTime zonedDateTime1 = LocalDateTime.now().minusDays(1).atZone(ZoneId.systemDefault());
        ZonedDateTime zonedDateTime2 = LocalDateTime.now().plusMinutes(1).atZone(ZoneId.systemDefault());
        return routeLocatorBuilder.routes()
                .route("before_route", route -> route.between(zonedDateTime1, zonedDateTime2).uri("http://baidu.com"))
                .build();
    }


//    Before
//    @Bean
//    public RouteLocator afterRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
//        ZonedDateTime zonedDateTime = LocalDateTime.now().plusMinutes(1).atZone(ZoneId.systemDefault());
//        System.out.println(zonedDateTime.toString());
//        return routeLocatorBuilder.routes()
//                .route("before_route", route -> route.before(zonedDateTime).uri("http://baidu.com"))
//                .build();
//    }

//    After
//    @Bean
//    public RouteLocator afterRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
//        ZonedDateTime zonedDateTime = LocalDateTime.now().minusSeconds(20).atZone(ZoneId.systemDefault());
//        return routeLocatorBuilder.routes()
//                .route("after_route", route -> route.after(zonedDateTime).uri("http://baidu.com"))
//                .build();
//    }

}
