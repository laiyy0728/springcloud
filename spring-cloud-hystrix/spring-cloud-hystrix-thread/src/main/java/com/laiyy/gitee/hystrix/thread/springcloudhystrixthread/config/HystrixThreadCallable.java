package com.laiyy.gitee.hystrix.thread.springcloudhystrixthread.config;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.concurrent.Callable;

/**
 * @author laiyy
 * @date 2019/2/12 11:34
 * @description
 */
public class HystrixThreadCallable<S> implements Callable<S> {

    private final RequestAttributes requestAttributes;
    private final Callable<S> callable;
    private String params;

    public HystrixThreadCallable(RequestAttributes requestAttributes, Callable<S> callable, String params) {
        this.requestAttributes = requestAttributes;
        this.callable = callable;
        this.params = params;
    }

    @Override
    public S call() throws Exception {
        try {
            RequestContextHolder.setRequestAttributes(requestAttributes);
            HystrixThreadLocal.threadLocal.set(params);
            return callable.call();
        } finally {
            RequestContextHolder.resetRequestAttributes();
            HystrixThreadLocal.threadLocal.remove();
        }
    }
}
