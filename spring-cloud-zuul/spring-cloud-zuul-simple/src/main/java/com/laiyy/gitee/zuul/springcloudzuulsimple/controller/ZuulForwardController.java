package com.laiyy.gitee.zuul.springcloudzuulsimple.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laiyy
 * @date 2019/2/15 13:52
 * @description
 */
@RestController
public class ZuulForwardController {

    @GetMapping(value = "/client")
    public String zuulForward(){
        return "zuul local forward!";
    }

}
