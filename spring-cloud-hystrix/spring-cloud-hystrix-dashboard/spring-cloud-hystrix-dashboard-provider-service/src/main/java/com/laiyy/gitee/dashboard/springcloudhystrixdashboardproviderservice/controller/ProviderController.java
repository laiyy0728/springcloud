package com.laiyy.gitee.dashboard.springcloudhystrixdashboardproviderservice.controller;

import com.laiyy.gitee.dashboard.springcloudhystrixdashboardproviderservice.feign.ProviderService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author laiyy
 * @date 2019/1/31 16:46
 * @description
 */
@RestController
public class ProviderController {

    private final ProviderService providerService;

    @Autowired
    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping(value = "/get-dashboard")
    public List<String> getProviderData(){
        List<String> provider = Lists.newArrayList();
        provider.add("hystrix dashboard");
        return provider;
    }

    @GetMapping(value = "/get-hello-service")
    public String getHelloService(){
        return providerService.helloService();
    }
}
