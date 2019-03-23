package com.ray.securitydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    /**
     * 登录页面
     */
    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    /**
     * 登录操作
     */
    @PostMapping("/login")
    public void login(String name, String password) {

    }


}
