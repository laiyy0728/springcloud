package com.laiyy.gitee.apm.springcloudapmsleuthconsumer.controller;

import com.laiyy.gitee.apm.springcloudapmsleuthconsumer.feign.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @author laiyy
 * @date 2019/4/11 16:36
 * description：
 */
@RestController
public class ConsumerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerController.class);

    private final HelloService helloService;
    private final RestTemplate restTemplate;
    private final ExecutorService executorService;

    @Autowired
    public ConsumerController(HelloService helloService, RestTemplate restTemplate, ExecutorService executorService) {
        this.helloService = helloService;
        this.restTemplate = restTemplate;
        this.executorService = executorService;
    }

    @GetMapping(value = "/hello-feign")
    public String helloByFeign(String name){
        LOGGER.info(">>>>>>>>>>>>>>>>>> feign 调用，参数：{} <<<<<<<<<<<<<<<<<<<<", name);
        String result = helloService.sayHello(name);
        LOGGER.info(">>>>>>>>>>>>>>>>>> feign 调用，结果：{} <<<<<<<<<<<<<<<<<<<<", result);
        return result;
    }

    @GetMapping(value = "/hello-rest")
    public String helloByRest(String name){
        LOGGER.info(">>>>>>>>>>>>>>>>>> rest 调用，参数：{} <<<<<<<<<<<<<<<<<<<<", name);
        String url = "http://localhost:8082/say?name=" + name;
        String result = restTemplate.getForObject(url, String.class);
        LOGGER.info(">>>>>>>>>>>>>>>>>> rest 调用，结果：{} <<<<<<<<<<<<<<<<<<<<", result);
        return result;
    }

    @GetMapping(value = "/hello-thread")
    public String helloByThread(String name) throws ExecutionException, InterruptedException {
        LOGGER.info(">>>>>>>>>>>>>>>>>> 线程 调用，参数：{} <<<<<<<<<<<<<<<<<<<<", name);
        String url = "http://localhost:8082/say?name=" + name;
        Future<String> future = executorService.submit(() -> {
            LOGGER.info(">>>>>>>>>>>>> 进入线程，参数：{} <<<<<<<<<<<<<<<<<<<", name);
            return restTemplate.getForObject(url, String.class);
        });
        String result = future.get();
        LOGGER.info(">>>>>>>>>>>>>>>>>> 线程 调用，结果：{} <<<<<<<<<<<<<<<<<<<<", result);
        return result;
    }

}
