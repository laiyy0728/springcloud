package com.laiyy.gitee.hystrix.thread.springcloudhystrixthread.config;

/**
 * @author laiyy
 * @date 2019/2/12 11:32
 * @description
 */
public class HystrixThreadLocal {

    public static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

}
