package com.laiyy.gitee.config.springcloudconfigjwtserver.security;

import com.laiyy.gitee.config.springcloudconfigjwtserver.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author laiyy
 * @date 2019/3/7 15:39
 * @description jwt 工具类
 */
@Component
public class JwtTokenUtil implements Serializable {
    private static final long serialVersionUID = -3526876116205422242L;

    private static final String CLAIM_KEY_USERNAME = "sub";

    private static final String CLAIM_KEY_AUDIENCE = "audience";

    private static final String CLAIM_KEY_CREATED = "created";

    private static final String AUDIENCE_UNKNOWN = "unknown";

    private static final String AUDIENCE_WEB = "web";

    private Key secret = MacProvider.generateKey();

    private final static Long EXPIRATION = 120L;

    /**
     * 生成 JwtToken
     * @param jwtUser 用户信息
     * @return jwtToken
     */
    public String generateToken(JwtUser jwtUser){
        Map<String, Object> claims = new HashMap<>(3);
        claims.put(CLAIM_KEY_AUDIENCE, AUDIENCE_WEB);
        claims.put(CLAIM_KEY_CREATED, new Date().getTime() / 1000);
        claims.put(CLAIM_KEY_USERNAME, jwtUser.getUsername());
        return generateToken(claims);
    }

    /**
     * 实际生成 Token 的方法
     * @param claims token 参数
     * @return token
     */
    private String generateToken(Map<String, Object> claims){
        return Jwts.builder().setClaims(claims).setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    /**
     * 设置过期时间
     * @return 过期时间
     */
    private Date generateExpirationDate(){
        return new Date(System.currentTimeMillis() + EXPIRATION * 1000);
    }

    /**
     * 从 token 中获取用户名
     * @param token token
     * @return 用户名
     */
    public String getUsernameFromToken(String token){
        if (StringUtils.isEmpty(toString())){
            return null;
        }
        String username;
        try {
            final Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e){
            username = null;
        }
        return username;
    }

    /**
     * 从 token 中获取签名
     * @param token token
     * @return 签名
     */
    private Claims getClaimsFromToken(String token){
        Claims claims;
        // 移除二方库中设置的前缀："Bearer:"
        final String tokenClean = token.substring(7);
        try {
            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(tokenClean).getBody();
        }catch (Exception e){
            claims = null;
        }
        return claims;
    }

    /**
     * 验证 token
     * @param token token
     * @param userDetails 用户信息
     * @return 验证结果
     */
    public boolean validateToken(String token, UserDetails userDetails){
        JwtUser jwtUser = (JwtUser) userDetails;
        final String username = getUsernameFromToken(token);
        return username.equals(jwtUser.getUsername()) && !isTokenExpired(token);
    }

    /**
     * 判断 token 是否过期
     * @param token token
     * @return 是否过期
     */
    private boolean isTokenExpired(String token){
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    /**
     * 获取 token 过期时间
     * @param token token
     * @return 过期时间
     */
    public Date getExpirationDateFromToken(String token){
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e){
            expiration = null;
        }
        return expiration;
    }

}
