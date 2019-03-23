package com.ray.securitydemo.controller;

import com.ray.securitydemo.config.CustomUserDetails;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.NullAuthoritiesMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private GrantedAuthoritiesMapper authoritiesMapper = new NullAuthoritiesMapper();

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/login")
    public void login(String name, String password) {

        UserDetails userDetails = new CustomUserDetails(name, password);
        Authentication result = new UsernamePasswordAuthenticationToken(
                userDetails, userDetails.getUsername(),
                authoritiesMapper.mapAuthorities(userDetails.getAuthorities()));
        SecurityContextHolder.getContext().setAuthentication(result);

    }

}
