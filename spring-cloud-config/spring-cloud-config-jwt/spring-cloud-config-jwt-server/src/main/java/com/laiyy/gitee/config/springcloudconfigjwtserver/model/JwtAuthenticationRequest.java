package com.laiyy.gitee.config.springcloudconfigjwtserver.model;

import java.io.Serializable;

/**
 * @author laiyy
 * @date 2019/3/7 14:08
 * @description
 */
public class JwtAuthenticationRequest implements Serializable {
    private static final long serialVersionUID = 2983923223655034236L;

    private String username;
    private String password;

    public JwtAuthenticationRequest() {
    }

    public JwtAuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "JwtAuthenticationRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
