package com.laiyy.gitee.dashboard.springcloudhystrixdashboardexception.fallback;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @author laiyy
 * @date 2019/2/1 11:17
 * @description
 */
public class FallBackOtherException extends HystrixCommand<String> {

    public FallBackOtherException() {
        super(HystrixCommandGroupKey.Factory.asKey("otherException"));
    }

    @Override
    protected String run() throws Exception {
        throw new Exception("other exception");
    }

    @Override
    protected String getFallback() {
        return "fallback!";
    }
}
