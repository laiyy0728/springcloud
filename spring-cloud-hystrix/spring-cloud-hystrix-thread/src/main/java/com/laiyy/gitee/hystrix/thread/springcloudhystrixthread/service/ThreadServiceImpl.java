package com.laiyy.gitee.hystrix.thread.springcloudhystrixthread.service;

import com.laiyy.gitee.hystrix.thread.springcloudhystrixthread.config.HystrixThreadLocal;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * @author laiyy
 * @date 2019/2/12 11:29
 * @description
 */
@Component
public class ThreadServiceImpl implements IThreadService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadServiceImpl.class);

    private final RestTemplate restTemplate;

    @Autowired
    public ThreadServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    @HystrixCommand
    public String getUser(int id) {
        LOGGER.info("================================== Service ==================================");
        LOGGER.info(" ThreadService, Current thread id : {}", Thread.currentThread().getId());
        LOGGER.info(" ThreadService, HystrixThreadLocal: {}", HystrixThreadLocal.threadLocal.get());
        LOGGER.info(" ThreadService, RequestContextHolder: {}", RequestContextHolder.currentRequestAttributes().getAttribute("userId", RequestAttributes.SCOPE_REQUEST));
        return restTemplate.getForObject("http://spring-cloud-hystrix-cache-provider-user/get-user/{1}", String.class, id);
    }
}
