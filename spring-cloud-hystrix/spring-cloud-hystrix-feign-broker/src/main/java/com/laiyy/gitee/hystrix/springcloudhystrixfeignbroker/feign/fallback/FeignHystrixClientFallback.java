package com.laiyy.gitee.hystrix.springcloudhystrixfeignbroker.feign.fallback;

import com.laiyy.gitee.hystrix.springcloudhystrixfeignbroker.feign.FeignHystrixClient;
import org.springframework.stereotype.Component;

/**
 * @author laiyy
 * @date 2019/1/31 15:50
 * @description
 */
@Component
public class FeignHystrixClientFallback implements FeignHystrixClient {
    @Override
    public String feignHystrix() {
        return "error! this is feign hystrix";
    }
}
