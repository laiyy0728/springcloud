package com.laiyy.gitee.config.springcloudconfigjwtserver.controller;

import com.laiyy.gitee.config.springcloudconfigjwtserver.model.JwtAuthenticationRequest;
import com.laiyy.gitee.config.springcloudconfigjwtserver.model.JwtAuthenticationResponse;
import com.laiyy.gitee.config.springcloudconfigjwtserver.model.JwtUser;
import com.laiyy.gitee.config.springcloudconfigjwtserver.security.JwtTokenUtil;
import com.laiyy.gitee.config.springcloudconfigjwtserver.security.MemberServiceImpl;
import com.laiyy.gitee.config.springcloudconfigjwtserver.security.WebAuthenticationDetailsSourceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author laiyy
 * @date 2019/3/8 9:37
 * @description
 */
@RestController
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenUtil jwtTokenUtil;

    private final MemberServiceImpl memberService;

    private final WebAuthenticationDetailsSourceImpl webAuthenticationDetailsSource;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, MemberServiceImpl memberService, WebAuthenticationDetailsSourceImpl webAuthenticationDetailsSource) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.memberService = memberService;
        this.webAuthenticationDetailsSource = webAuthenticationDetailsSource;
    }

    @PostMapping(value = "/auth")
    public ResponseEntity<?> createAuthecticationToken(HttpServletRequest request) {
        JwtAuthenticationRequest jwtAuthenticationRequest = webAuthenticationDetailsSource.buildDetails(request);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(jwtAuthenticationRequest.getUsername(), jwtAuthenticationRequest.getPassword());
        authenticationToken.setDetails(jwtAuthenticationRequest);
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        JwtUser userDetails = (JwtUser) memberService.loadUserByUsername(jwtAuthenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }
}
