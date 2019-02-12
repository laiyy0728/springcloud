package com.laiyy.gitee.hystrix.thread.springcloudhystrixthread.controller;

import com.laiyy.gitee.hystrix.thread.springcloudhystrixthread.config.HystrixThreadLocal;
import com.laiyy.gitee.hystrix.thread.springcloudhystrixthread.service.IThreadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * @author laiyy
 * @date 2019/2/12 14:23
 * @description
 */
@RestController
public class ThreadController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadController.class);

    private final IThreadService threadService;

    @Autowired
    public ThreadController(IThreadService threadService) {
        this.threadService = threadService;
    }

    @GetMapping(value = "/get-user/{id}")
    public String getUser(@PathVariable int id) {
        // 放入上下文
        HystrixThreadLocal.threadLocal.set("userId:" + id);
        // 利用 RequestContextHolder
        RequestContextHolder.currentRequestAttributes().setAttribute("userId", "userId:" + id, RequestAttributes.SCOPE_REQUEST);
        LOGGER.info("================================== Controller ==================================");
        LOGGER.info(" ThreadService, Current thread id : {}", Thread.currentThread().getId());
        LOGGER.info(" ThreadService, HystrixThreadLocal: {}", HystrixThreadLocal.threadLocal.get());
        LOGGER.info(" ThreadService, RequestContextHolder: {}", RequestContextHolder.currentRequestAttributes().getAttribute("userId", RequestAttributes.SCOPE_REQUEST));
        return threadService.getUser(id);
    }


}
