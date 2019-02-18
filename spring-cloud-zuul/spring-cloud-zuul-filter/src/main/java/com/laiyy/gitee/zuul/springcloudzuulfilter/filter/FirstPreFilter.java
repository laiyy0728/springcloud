package com.laiyy.gitee.zuul.springcloudzuulfilter.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.FilterType;

/**
 * @author laiyy
 * @date 2019/2/18 11:20
 * @description
 */
public class FirstPreFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(FirstPreFilter.class);

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        LOGGER.info(">>>>>>>>>>>>>>>>> 自定义 Filter，类型为 pre！ <<<<<<<<<<<<<<<<<<");
        return null;
    }
}
