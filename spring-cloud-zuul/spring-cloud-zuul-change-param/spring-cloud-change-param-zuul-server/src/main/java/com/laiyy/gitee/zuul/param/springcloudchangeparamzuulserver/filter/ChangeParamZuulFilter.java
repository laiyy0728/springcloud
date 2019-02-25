package com.laiyy.gitee.zuul.param.springcloudchangeparamzuulserver.filter;

import com.google.common.collect.Maps;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.assertj.core.util.Lists;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author laiyy
 * @date 2019/2/25 14:49
 * @description
 */
@Configuration
public class ChangeParamZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER + 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        Map<String, List<String>> requestQueryParams = currentContext.getRequestQueryParams();
        if (requestQueryParams == null) {
            requestQueryParams = Maps.newHashMap();
        }

        List<String> arrayList = Lists.newArrayList();
        arrayList.add("1111111");
        requestQueryParams.put("test", arrayList);
        currentContext.setRequestQueryParams(requestQueryParams);
        return null;
    }
}
