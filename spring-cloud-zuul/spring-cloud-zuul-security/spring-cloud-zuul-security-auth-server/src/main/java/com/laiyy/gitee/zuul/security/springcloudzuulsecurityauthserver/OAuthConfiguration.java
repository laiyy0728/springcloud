package com.laiyy.gitee.zuul.security.springcloudzuulsecurityauthserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author laiyy
 * @date 2019/2/18 17:11
 * @description
 */
@Configuration
@EnableAuthorizationServer
public class OAuthConfiguration extends AuthorizationServerConfigurerAdapter {

    private final AuthenticationManager authenticationManager;

    @Autowired
    public OAuthConfiguration(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                // 此处的 client 是 zuul server 中 security.oauth2.client.client-id
                .withClient("zuul_server")
                // 此处的 secret 是 zuul server 中 security.oauth2.client.client-secret
                .secret("secret")
                // 作用域
                .scopes("WRIGHT", "READ")
                // 跳过认证确认的过程
                .autoApprove(true)
                // 权限
                .authorities("WRIGHT_READ", "WRIGHT_WRITE")
                // 可以使用的授权类型，默认为空
                // implicit：隐式授权类型
                // refresh_token：刷新令牌获取新的令牌
                // password：资源所有者密码类型
                // authorization_code：授权码类型
                // client_credentials：客户端凭据（客户端ID以及key）类型
                .authorizedGrantTypes("implicit", "refresh_token", "password", "authorization_code");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(jwtTokenStore())
                .tokenEnhancer(jwtAccessTokenConverter())
                .authenticationManager(authenticationManager);
    }

    @Bean
    public TokenStore jwtTokenStore(){
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey("spring-cloud");
        return jwtAccessTokenConverter;
    }
}
