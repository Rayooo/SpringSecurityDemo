package com.ray.securitydemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login.html");
        registry.addViewController("/home").setViewName("home.html");
        registry.addViewController("/").setViewName("home.html");
        registry.addViewController("/register").setViewName("register.html");

        //hello页面控制权限
        registry.addViewController("/hello").setViewName("hello.html");
    }
}
