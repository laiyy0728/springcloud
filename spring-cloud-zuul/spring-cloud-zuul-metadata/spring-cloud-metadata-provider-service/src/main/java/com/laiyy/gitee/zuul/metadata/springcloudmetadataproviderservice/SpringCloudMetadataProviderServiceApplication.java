package com.laiyy.gitee.zuul.metadata.springcloudmetadataproviderservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class SpringCloudMetadataProviderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudMetadataProviderServiceApplication.class, "--Dspring.profiles.active=node1");
    }

    @Value("${server.port}")
    private int port;

    @GetMapping(value = "/get-result")
    public String getResult(){
        return "metadata provider service result, port: " + port;
    }
}
