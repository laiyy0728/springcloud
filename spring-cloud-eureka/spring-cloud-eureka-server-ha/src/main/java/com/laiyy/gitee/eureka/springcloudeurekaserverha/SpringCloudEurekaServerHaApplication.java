package com.laiyy.gitee.eureka.springcloudeurekaserverha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.eureka.server.EurekaServerConfigBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaServer
@RestController
public class SpringCloudEurekaServerHaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaServerHaApplication.class, args);
    }


    @Autowired
    private EurekaClientConfigBean eurekaClientConfigBean;

    @GetMapping(value = "eureka-service-url")
    public Object getEurekaServerUrl() {
        return eurekaClientConfigBean.getServiceUrl();
    }

}

