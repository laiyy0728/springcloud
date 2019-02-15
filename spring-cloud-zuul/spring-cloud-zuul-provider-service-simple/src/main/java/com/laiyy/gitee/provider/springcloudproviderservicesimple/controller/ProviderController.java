package com.laiyy.gitee.provider.springcloudproviderservicesimple.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author laiyy
 * @date 2019/2/14 10:04
 * @description
 */
@RestController
public class ProviderController {

    @Value("${server.port}")
    private int serverPort;

    @GetMapping(value = "/get-result")
    public String provider(HttpServletRequest request){
        Enumeration<String> headerNames = request.getHeaderNames();
        StringBuilder headers = new StringBuilder();
        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement();
            String value = request.getHeader(header);
            headers.append("[").append(header).append("]: ").append(value).append("; ");
        }
        return "this is provider service! this port is: " + serverPort + " headers: " + headers;
    }

}
