package com.laiyy.gitee.config.springcloudconfigjwtserver.model;

import java.io.Serializable;

/**
 * @author laiyy
 * @date 2019/3/7 14:11
 * @description
 */
public class JwtAuthenticationResponse implements Serializable {
    private static final long serialVersionUID = -539701396170611753L;

    private final String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
