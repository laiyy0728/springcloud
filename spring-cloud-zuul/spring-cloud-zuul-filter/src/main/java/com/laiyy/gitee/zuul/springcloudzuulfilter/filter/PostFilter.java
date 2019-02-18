package com.laiyy.gitee.zuul.springcloudzuulfilter.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * @author laiyy
 * @date 2019/2/18 13:56
 * @description
 */
public class PostFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostFilter.class);

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
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
        LOGGER.info(">>>>>>>>>>>>>>>>>>> Post Filter! <<<<<<<<<<<<<<<<");
        RequestContext context = RequestContext.getCurrentContext();
        // 处理返回中文乱码
        context.getResponse().setCharacterEncoding("UTF-8");
        // 获取上下文保存的 responseBody
        String responseBody = context.getResponseBody();
        // 如果 responseBody 不为空，则证明流程中有异常发生
        if (StringUtils.isNotBlank(responseBody)) {
            // 设置返回状态码
            context.setResponseStatusCode(500);
            // 替换响应报文
            context.setResponseBody(responseBody);
        }
        return null;
    }
}
