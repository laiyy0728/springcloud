package com.laiyy.gitee.hystrix.springcloudhystrixfeignbroker.controller;

import com.laiyy.gitee.hystrix.springcloudhystrixfeignbroker.feign.FeignHystrixClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laiyy
 * @date 2019/1/31 15:49
 * @description
 */
@RestController
public class FeignHystrixController {

    private final FeignHystrixClient feignHystrixClient;

    @Autowired
    public FeignHystrixController(FeignHystrixClient feignHystrixClient) {
        this.feignHystrixClient = feignHystrixClient;
    }

    @GetMapping(value = "feign-hystrix")
    public String feignHystrix(){
        return feignHystrixClient.feignHystrix();
    }
}
