package com.ray.securitydemo.controller;

import com.ray.securitydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class SecurityController {

    @Autowired
    private UserService userService;


    @RequestMapping("delete")
    public String deleteRequest(HttpServletRequest request) {
        return userService.delete();
    }

    @RequestMapping("update")
    public String updateRequest() {
        return userService.update();
    }


}
