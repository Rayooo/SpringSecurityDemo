package com.ray.securitydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home").permitAll()  // / & /home 不需要认证
                .anyRequest()
                .authenticated()
                .and()
            .formLogin()
                .loginPage("/login")         // 指定登录地址
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails  user = User.withDefaultPasswordEncoder()           //指定了一个内存用户
                .username("user")
                .password("123")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}
