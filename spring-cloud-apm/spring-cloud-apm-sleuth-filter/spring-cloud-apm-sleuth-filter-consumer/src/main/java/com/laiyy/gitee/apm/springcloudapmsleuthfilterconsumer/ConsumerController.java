package com.laiyy.gitee.apm.springcloudapmsleuthfilterconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laiyy
 * @date 2019/4/12 16:28
 * description：
 */
@RestController
public class ConsumerController {
    private final HelloService helloService;

    @Autowired
    public ConsumerController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping(value = "/hello")
    public String hello(String name){
        return helloService.say(name);
    }
}
