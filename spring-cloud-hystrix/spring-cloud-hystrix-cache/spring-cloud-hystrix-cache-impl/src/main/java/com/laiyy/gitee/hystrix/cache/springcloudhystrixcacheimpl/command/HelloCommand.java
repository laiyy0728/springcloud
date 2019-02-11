package com.laiyy.gitee.hystrix.cache.springcloudhystrixcacheimpl.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixRequestCache;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;
import org.springframework.web.client.RestTemplate;

/**
 * @author laiyy
 * @date 2019/2/11 14:08
 * @description
 */
public class HelloCommand extends HystrixCommand<String> {

    private RestTemplate restTemplate;

    private int id;

    public HelloCommand(RestTemplate restTemplate, int id){
        super(HystrixCommandGroupKey.Factory.asKey("springCloudCacheGroup"));
        this.id = id;
        this.restTemplate = restTemplate;
    }

    @Override
    protected String run() throws Exception {
        String result = restTemplate.getForObject("http://spring-cloud-hystrix-cache-provider-user/get-user/{1}", String.class, id);
        System.out.println("正在使用继承 HystrixCommand 方式进行远程调用：" + result);
        return result;
    }

    @Override
    protected String getFallback() {
        return "hello command fallback";
    }

    @Override
    protected String getCacheKey() {
        return String.valueOf(id);
    }

    public static void cleanCache(int id) {
        HystrixRequestCache.getInstance(
                HystrixCommandKey.Factory.asKey("springCloudCacheGroup"),
                HystrixConcurrencyStrategyDefault.getInstance())
                .clear(String.valueOf(id));
    }
}
