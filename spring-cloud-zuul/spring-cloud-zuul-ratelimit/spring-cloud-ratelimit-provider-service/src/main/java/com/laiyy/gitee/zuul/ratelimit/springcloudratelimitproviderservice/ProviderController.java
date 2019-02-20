package com.laiyy.gitee.zuul.ratelimit.springcloudratelimitproviderservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laiyy
 * @date 2019/2/20 14:49
 * @description
 */
@RestController
public class ProviderController {

    @GetMapping(value = "/get-result")
    public String result(){
        return "zuul rate limit result !";
    }

}
