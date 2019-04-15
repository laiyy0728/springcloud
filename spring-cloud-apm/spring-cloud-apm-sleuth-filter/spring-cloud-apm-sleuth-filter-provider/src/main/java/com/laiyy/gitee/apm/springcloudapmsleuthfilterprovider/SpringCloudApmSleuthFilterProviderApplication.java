package com.laiyy.gitee.apm.springcloudapmsleuthfilterprovider;

import brave.propagation.ExtraFieldPropagation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringCloudApmSleuthFilterProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudApmSleuthFilterProviderApplication.class, args);
    }

    @GetMapping(value = "/say")
    public String hello(String name){
        return "你好啊！" + name + ", 你的 session id 是：" + ExtraFieldPropagation.get("SessionId");
    }

}
