package com.laiyy.gitee.config.springcloudconfigjwtserver.security;

import com.google.gson.Gson;
import com.laiyy.gitee.config.springcloudconfigjwtserver.model.JwtAuthenticationRequest;
import org.springframework.security.authentication.AuthenticationDetailsSource;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author laiyy
 * @date 2019/3/7 16:36
 * @description 将传递过来的对象数据封装到 JwtAuthenticationRequest 中
 */
public class WebAuthenticationDetailsSourceImpl implements AuthenticationDetailsSource<HttpServletRequest, JwtAuthenticationRequest> {
    @Override
    public JwtAuthenticationRequest buildDetails(HttpServletRequest request) {
        StringBuilder builder = new StringBuilder();
        JwtAuthenticationRequest jwtAuthenticationRequest = new JwtAuthenticationRequest();
        BufferedReader reader = null;
        String output;
        try {
            // 从 httpServletRequest 请求中获取信息
            reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
            while ((output = reader.readLine()) != null){
                builder.append(output);
            }
            // 转换为 JwtAuthenticationRequest
            jwtAuthenticationRequest =  new Gson().fromJson(builder.toString(), JwtAuthenticationRequest.class);
        } catch (Exception e){
            e.printStackTrace();;
        } finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return jwtAuthenticationRequest;
    }
}
