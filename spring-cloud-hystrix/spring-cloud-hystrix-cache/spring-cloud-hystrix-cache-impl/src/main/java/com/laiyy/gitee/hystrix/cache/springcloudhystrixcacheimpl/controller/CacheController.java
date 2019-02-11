package com.laiyy.gitee.hystrix.cache.springcloudhystrixcacheimpl.controller;

import com.laiyy.gitee.hystrix.cache.springcloudhystrixcacheimpl.command.HelloCommand;
import com.laiyy.gitee.hystrix.cache.springcloudhystrixcacheimpl.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author laiyy
 * @date 2019/2/11 14:02
 * @description
 */
@RestController
public class CacheController {

    private final RestTemplate restTemplate;

    private final IHelloService helloService;

    @Autowired
    public CacheController(RestTemplate restTemplate, IHelloService helloService) {
        this.restTemplate = restTemplate;
        this.helloService = helloService;
    }

    /**
     * 缓存测试
     */
    @GetMapping(value = "/get-user/{id}")
    public String getUser(@PathVariable int id) {
        helloService.hello(id);
        helloService.hello(id);
        helloService.hello(id);
        helloService.hello(id);
        return "getUser success!";
    }

    /**
     * 缓存更新
     */
    @GetMapping(value = "/get-user-id-update/{id}")
    public String getUserIdUpdate(@PathVariable int id){
        helloService.hello(id);
        helloService.hello(id);
        helloService.hello(5);
        helloService.hello(5);
        return "getUserIdUpdate success!";
    }

    /**
     * 继承 HystrixCommand 方式
     */
    @GetMapping(value = "/get-user-id-by-command/{id}")
    public String getUserIdByCommand(@PathVariable int id){
        HelloCommand helloCommand = new HelloCommand(restTemplate, id);
        helloCommand.execute();
        System.out.println("from Cache:"  + helloCommand.isResponseFromCache()) ;
        helloCommand = new HelloCommand(restTemplate, id);
        helloCommand.execute();
        System.out.println("from Cache:"  + helloCommand.isResponseFromCache()) ;
        // 清理缓存
        HelloCommand.cleanCache(id);
        helloCommand = new HelloCommand(restTemplate, id);
        helloCommand.execute();
        System.out.println("from Cache:"  + helloCommand.isResponseFromCache()) ;
        helloCommand = new HelloCommand(restTemplate, id);
        helloCommand.execute();
        System.out.println("from Cache:"  + helloCommand.isResponseFromCache()) ;
        return "getUserIdByCommand success!";
    }

    /**
     * 缓存、清除缓存
     */
    @GetMapping(value = "/get-and-update/{id}")
    public String getAndUpdateUser(@PathVariable int id){
        // 缓存数据
        helloService.getUserToCommandKey(id);
        helloService.getUserToCommandKey(id);

        // 缓存清除
        helloService.updateUser(id);

        // 再次缓存
        helloService.getUserToCommandKey(id);
        helloService.getUserToCommandKey(id);

        return "getAndUpdateUser success!";
    }



}
