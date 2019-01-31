package com.laiyy.gitee.hystrix.springcloudhystrixsimple.service;

/**
 * @author laiyy
 * @date 2019/1/31 15:16
 * @description
 */
public interface HystrixService {

    String getUser(String username) throws Exception;

}
