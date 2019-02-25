package com.laiyy.gitee.zuul.param.springcloudchangeparamzuulserver.config;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author laiyy
 * @date 2019/2/25 15:24
 * @description
 */
@Configuration
@EnableSwagger2
//@EnableWebMvc
public class Swagger2Configuration {

    private final ZuulProperties zuulProperties;

    @Autowired
    public Swagger2Configuration(ZuulProperties zuulProperties) {
        this.zuulProperties = zuulProperties;
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("spring cloud swagger 2")
                .description("spring cloud 整合 swagger2")
                .termsOfServiceUrl("")
                .contact(new Contact("1", "1", "1")).version("1.0")
                .build();
    }

    @Primary
    @Bean
    public SwaggerResourcesProvider swaggerResourcesProvider() {
        return () -> {
            List<SwaggerResource> resources = new ArrayList<>();
            zuulProperties.getRoutes().values().stream()
                    .forEach(route -> resources.add(createResource(route.getServiceId(), route.getServiceId(), "2.0")));
            return resources;
        };
    }

    private SwaggerResource createResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation("/" + location + "/v2/api-docs");
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }

//    @Component
//    @Primary
//    public class ZuulSwaggerResourceProvider implements SwaggerResourcesProvider {
//
//        private final RouteLocator routeLocator;
//
//        @Autowired
//        public ZuulSwaggerResourceProvider(RouteLocator routeLocator) {
//            this.routeLocator = routeLocator;
//        }
//
//        @Override
//        public List<SwaggerResource> get() {
//            List<SwaggerResource> resources = Lists.newArrayList();
//            routeLocator.getRoutes().forEach(route -> {
//                resources.add(createResource(route.getId(), route.getFullPath().replace("**", "v2/api-docs")));
//            });
//            return resources;
//        }
//
//        private SwaggerResource createResource(String name, String location) {
//            SwaggerResource swaggerResource = new SwaggerResource();
//            swaggerResource.setName(name);
//            swaggerResource.setLocation(location);
////            swaggerResource.setLocation("/" + location + "/api-docs");
//            swaggerResource.setSwaggerVersion("2.0");
//            return swaggerResource;
//        }
//    }
}
