package com.ray.securitydemo.controller;

import com.ray.securitydemo.dao.IUserAndRoleDao;
import com.ray.securitydemo.dao.IUserDao;
import com.ray.securitydemo.entity.User;
import com.ray.securitydemo.entity.UserAndRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IUserAndRoleDao userAndRoleDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * 注册页面
     */
    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    /**
     * 注册操作
     */
    @PostMapping("/register")
    @ResponseBody
    public String register(String userName, String password) {
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            return "注册失败";
        }

        var passwordAfterEncode = passwordEncoder.encode(password);

        //自定义的User
        var user = User.builder()
                .userName(userName)
                .password(passwordAfterEncode)
                .build();

        userDao.save(user);


        var userAndRole = UserAndRole.builder()
                .userId(user.getId())
                .roleId(1L)
                .build();

        userAndRoleDao.save(userAndRole);

        return "注册成功";
    }

}
