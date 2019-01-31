package com.laiyy.gitee.hystrix.springcloudhystrixsimple.controller;

import com.laiyy.gitee.hystrix.springcloudhystrixsimple.service.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laiyy
 * @date 2019/1/31 15:16
 * @description
 */
@RestController
public class HystrixController {

    private final HystrixService hystrixService;

    @Autowired
    public HystrixController(HystrixService hystrixService) {
        this.hystrixService = hystrixService;
    }

    @GetMapping(value = "get-user")
    public String getUser(@RequestParam String username) throws Exception{
        return hystrixService.getUser(username);
    }
}
