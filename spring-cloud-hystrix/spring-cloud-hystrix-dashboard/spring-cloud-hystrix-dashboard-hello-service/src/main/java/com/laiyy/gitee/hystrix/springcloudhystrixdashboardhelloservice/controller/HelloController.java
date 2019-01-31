package com.laiyy.gitee.hystrix.springcloudhystrixdashboardhelloservice.controller;

import com.laiyy.gitee.hystrix.springcloudhystrixdashboardhelloservice.feign.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author laiyy
 * @date 2019/1/31 16:25
 * @description
 */
@RestController
public class HelloController {

    private final ProviderService providerService;

    @Autowired
    public HelloController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping(value = "get-provider-data")
    public List<String> getProviderData(){
        return providerService.getProviderData();
    }


    @GetMapping(value = "/hello-service")
    public String helloService(){
        return "hello service!";
    }
}
