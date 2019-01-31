package com.laiyy.gitee.hystrix.springcloudhystrixsimple.service.impl;

import com.laiyy.gitee.hystrix.springcloudhystrixsimple.service.HystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

/**
 * @author laiyy
 * @date 2019/1/31 15:17
 * @description
 */
@Service
public class HystrixServiceImpl implements HystrixService {
    @Override
    @HystrixCommand(fallbackMethod = "defaultUser")
    public String getUser(String username) throws Exception {
        if ("laiyy".equals(username)) {
            return "this is real user, name:" + username;
        }
        throw new Exception();
    }

    /**
     * 在 getUser 出错时调用
     */
    public String defaultUser(String username) {
        return "this is error user, name: " + username;
    }

}
