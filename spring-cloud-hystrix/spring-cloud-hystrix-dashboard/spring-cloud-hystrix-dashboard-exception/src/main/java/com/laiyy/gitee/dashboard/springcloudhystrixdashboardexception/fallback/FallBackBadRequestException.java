package com.laiyy.gitee.dashboard.springcloudhystrixdashboardexception.fallback;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author laiyy
 * @date 2019/2/1 11:08
 * @description
 */
public class FallBackBadRequestException extends HystrixCommand<String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(FallBackBadRequestException.class);

    public FallBackBadRequestException() {
        super(HystrixCommandGroupKey.Factory.asKey("GroupBadRequestException"));
    }

    @Override
    protected String run() throws Exception {
        throw new HystrixBadRequestException("this is HystrixBadRequestException！");
    }

    @Override
    protected String getFallback() {
        System.out.println("Fallback 错误信息：" + getFailedExecutionException().getMessage());
        return "this is HystrixBadRequestException Fallback method!";
    }
}
