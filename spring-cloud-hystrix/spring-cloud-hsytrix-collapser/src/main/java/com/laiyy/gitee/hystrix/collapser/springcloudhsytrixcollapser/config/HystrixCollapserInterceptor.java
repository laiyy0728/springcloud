package com.laiyy.gitee.hystrix.collapser.springcloudhsytrixcollapser.config;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author laiyy
 * @date 2019/2/12 10:10
 * @description
 */
public class HystrixCollapserInterceptor implements HandlerInterceptor {

    private HystrixRequestContext context;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        context = HystrixRequestContext.initializeContext();
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        context.shutdown();
    }
}
