package com.laiyy.gitee.zuul.param.springcloudchangeparamprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class SpringCloudChangeParamProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudChangeParamProviderApplication.class, args);
    }

}
