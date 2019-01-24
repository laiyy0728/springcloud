package com.laiyy.gitee.feign.multi.params.springcloudfeignmultiparamsprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudFeignMultiParamsProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudFeignMultiParamsProviderApplication.class, args);
    }

}

