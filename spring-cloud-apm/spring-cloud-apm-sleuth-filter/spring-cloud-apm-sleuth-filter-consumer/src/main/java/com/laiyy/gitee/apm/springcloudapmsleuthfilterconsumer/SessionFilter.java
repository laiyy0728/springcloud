package com.laiyy.gitee.apm.springcloudapmsleuthfilterconsumer;

import brave.propagation.ExtraFieldPropagation;
import org.springframework.cloud.sleuth.instrument.web.SleuthWebProperties;
import org.springframework.cloud.sleuth.instrument.web.TraceWebServletAutoConfiguration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * @author laiyy
 * @date 2019/4/12 16:17
 * description：
 */
@Component
@Order(TraceWebServletAutoConfiguration.TRACING_FILTER_ORDER + 1)
public class SessionFilter extends GenericFilterBean {

    private Pattern pattern = Pattern.compile(SleuthWebProperties.DEFAULT_SKIP_PATTERN);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        if (!(request instanceof HttpServletRequest) || !(response instanceof HttpServletResponse)) {
            throw new ServletException("只支持 Http 请求");
        }

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        boolean matches = pattern.matcher(httpServletRequest.getRequestURI()).matches();

        if (!matches){
            ExtraFieldPropagation.set("SessionId", httpServletRequest.getSession().getId());
        }
        filterChain.doFilter(request, response);
    }
}
