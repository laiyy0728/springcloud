package com.laiyy.gitee.dashboard.springcloudhystrixdashboardexception.controller;

import com.laiyy.gitee.dashboard.springcloudhystrixdashboardexception.fallback.FallBackBadRequestException;
import com.laiyy.gitee.dashboard.springcloudhystrixdashboardexception.fallback.FallBackOtherException;
import com.laiyy.gitee.dashboard.springcloudhystrixdashboardexception.feign.ProviderFeignClient;
import com.laiyy.gitee.dashboard.springcloudhystrixdashboardexception.feign.ProviderServiceCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laiyy
 * @date 2019/2/1 11:20
 * @description
 */
@RestController
public class ExceptionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);

    @GetMapping(value = "provider-service-command")
    public String providerServiceCommand(){
        return new ProviderServiceCommand("laiyy").execute();
    }


    @GetMapping(value = "fallback-bad-request")
    public String fallbackBadRequest(){
        return new FallBackBadRequestException().execute();
    }

    @GetMapping(value = "fallback-other")
    public String fallbackOther(){
        return new FallBackOtherException().execute();
    }

    @GetMapping(value = "fallback-method")
    @HystrixCommand(fallbackMethod = "fallback")
    public String fallbackMethod(String id){
        throw new RuntimeException("fallback method !");
    }

    public String fallback(String id, Throwable throwable){
        LOGGER.error(">>>>>>>>>>>>>>> 进入 @HystrixCommand fallback！");
        return "this is @HystrixCommand fallback!";
    }


    @Autowired
    private ProviderFeignClient feignClient;

    @GetMapping(value = "bad-request")
    @HystrixCommand(fallbackMethod = "bakRequestFallback")
    public String badRequest(String age){
        return feignClient.badRequest(age);
    }

    public String bakRequestFallback(String age){
        return "bad request fallback!";
    }
}
