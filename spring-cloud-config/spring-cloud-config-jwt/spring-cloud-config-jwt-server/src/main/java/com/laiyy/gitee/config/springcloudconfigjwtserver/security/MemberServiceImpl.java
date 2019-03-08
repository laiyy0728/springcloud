package com.laiyy.gitee.config.springcloudconfigjwtserver.security;

import com.laiyy.gitee.config.springcloudconfigjwtserver.model.JwtUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * @author laiyy
 * @date 2019/3/7 16:08
 * @description 获取用户信息
 */
@Service("userDetailsService")
public class MemberServiceImpl implements UserDetailsService {

    private static final PasswordEncoder BCRYPT = new BCryptPasswordEncoder();

    @Value("${spring.security.user.name}")
    private String hardcodeUser;

    @Value("${spring.security.user.password}")
    private String password;

    /**
     * 获取用户信息
     * @param username 用户名
     * @return 用户信息
     * @throws UsernameNotFoundException 用户未发现异常
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 对密码进行加密
        String hardcodePassword = BCRYPT.encode(password);
        if (!username.equals(hardcodeUser)){
            throw new UsernameNotFoundException("No user found with username : " + username);
        } else {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            grantedAuthorities.add(simpleGrantedAuthority);
            return new JwtUser(hardcodeUser, hardcodePassword, grantedAuthorities);
        }
    }
}
