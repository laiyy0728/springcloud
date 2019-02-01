package com.laiyy.gitee.dashboard.springcloudhystrixdashboardexception.feign;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @author laiyy
 * @date 2019/2/1 11:18
 * @description
 */
public class ProviderServiceCommand extends HystrixCommand<String> {

    private final String name;

    public ProviderServiceCommand(String name){
        super(HystrixCommandGroupKey.Factory.asKey("springCloud"));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        return "spring cloud!" + name;
    }

    @Override
    protected String getFallback() {
        return "spring cloud fail!";
    }
}
