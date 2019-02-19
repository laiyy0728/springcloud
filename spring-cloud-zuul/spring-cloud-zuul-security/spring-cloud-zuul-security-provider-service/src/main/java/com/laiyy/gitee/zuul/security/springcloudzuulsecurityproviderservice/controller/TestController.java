package com.laiyy.gitee.zuul.security.springcloudzuulsecurityproviderservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laiyy
 * @date 2019/2/19 14:08
 * @description
 */
@RestController
public class TestController {

    @GetMapping(value = "/add")
    public Integer add(Integer a, Integer b) {
        return a + b;
    }
}
