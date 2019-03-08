package com.laiyy.gitee.config.springcloudconfigjwtserver.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * @author laiyy
 * @date 2019/3/7 17:00
 * @description 401
 */
@Component
public class JwtAuthenticationEntryEndpoint implements AuthenticationEntryPoint, Serializable {
    private static final long serialVersionUID = 1166160276681022472L;

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    }
}
