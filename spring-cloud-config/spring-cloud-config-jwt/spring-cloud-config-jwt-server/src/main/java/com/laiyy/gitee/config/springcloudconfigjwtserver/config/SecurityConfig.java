package com.laiyy.gitee.config.springcloudconfigjwtserver.config;

import com.laiyy.gitee.config.springcloudconfigjwtserver.security.JwtAuthenticationEntryEndpoint;
import com.laiyy.gitee.config.springcloudconfigjwtserver.security.JwtAuthenticationTokenFilter;
import com.laiyy.gitee.config.springcloudconfigjwtserver.security.WebAuthenticationDetailsSourceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.DispatcherType;
import java.util.Collections;

/**
 * @author laiyy
 * @date 2019/3/7 17:11
 * @description
 */
@ContextConfiguration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtAuthenticationEntryEndpoint jwtAuthenticationEntryEndpoint;

    private final WebAuthenticationDetailsSourceImpl webAuthenticationDetailsSource;

    @Autowired
    public SecurityConfig(JwtAuthenticationEntryEndpoint jwtAuthenticationEntryEndpoint, WebAuthenticationDetailsSourceImpl webAuthenticationDetailsSource) {
        this.jwtAuthenticationEntryEndpoint = jwtAuthenticationEntryEndpoint;
        this.webAuthenticationDetailsSource = webAuthenticationDetailsSource;
    }

    /**
     * 当 AuthenticationManager 不存在时，向 Spring 容器注入 UsernamePasswordAuthenticationFilter
     * @param authenticationManager AuthenticationManager
     * @return UsernamePasswordAuthenticationFilter
     */
    @Bean
    @ConditionalOnMissingBean(AuthenticationManager.class)
    public UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter(AuthenticationManager authenticationManager){
        UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter = new UsernamePasswordAuthenticationFilter();
        usernamePasswordAuthenticationFilter.setAuthenticationManager(authenticationManager);
        usernamePasswordAuthenticationFilter.setAuthenticationDetailsSource(webAuthenticationDetailsSource);
        return usernamePasswordAuthenticationFilter;
    }

    /**
     * 向 Spring 容器注入 AuthenticationManager
     *
     * @return AuthenticationManager
     * @throws Exception 可能出现的异常
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() // 禁用跨域
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryEndpoint) // 设置 endpoint
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 设置  session 管理器。 ALWAYS：总是创建 sesion，IF_REQUIRED：只会在需要的时候创建，NEVER：不会创建，但是如果存在的话，会使用 session，STATELESS：永远不会创建，不会使用 session 获取 SecurityContext
                .and()
                .authorizeRequests().antMatchers(HttpMethod.GET, "/").permitAll()   // 所有的 GET 请求都要经过校验
                .antMatchers("/auth/**").permitAll()    // 所有的以 /auth 开头的请求，都要经过校验
                .anyRequest().authenticated()   // 都要有权限
                .and()
                .formLogin().authenticationDetailsSource(webAuthenticationDetailsSource).permitAll();   // 设置验证信息源

    }

    /**
     * 密码编码器
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * jwt filter
     */
    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() throws Exception {
        JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter = new JwtAuthenticationTokenFilter();
        jwtAuthenticationTokenFilter.setAuthenticationManager(authenticationManager());
        jwtAuthenticationTokenFilter.setAuthenticationDetailsSource(webAuthenticationDetailsSource);
        return jwtAuthenticationTokenFilter;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() throws Exception {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new DelegatingFilterProxy(jwtAuthenticationTokenFilter()));
        registrationBean.addInitParameter("targetFilterLifecycle", "true");
        registrationBean.setUrlPatterns(Collections.singleton("/*"));
        registrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico");
        registrationBean.setDispatcherTypes(DispatcherType.REQUEST);

        registrationBean.setEnabled(false);
        return registrationBean;
    }


}
