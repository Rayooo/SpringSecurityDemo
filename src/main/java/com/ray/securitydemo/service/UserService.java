package com.ray.securitydemo.service;

import com.ray.securitydemo.constants.RoleConstants;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    /**
     * 提供方法级别的控制
     * <p>
     * 只能admin访问
     */
    @Secured(RoleConstants.ADMIN)
    public String delete() {
        return "Delete. (You are admin)";
    }

    /**
     * 只能admin和normal访问
     */
    @Secured({RoleConstants.ADMIN, RoleConstants.NORMAL})
    public String update() {
        return "Update. (You are admin or normal)";
    }


    /**
     * 支持EL表达式
     */
    @PostAuthorize("returnObject.length() == authentication.name")
    public String findById(int id) {
        return "123";
    }

    /**
     * 同时拥有 ADMIN 和 DBA 才能访问
     */
    @PreAuthorize("hasRole('ADMIN') AND hasRole('DBA')")
    void deleteUser() {

    }


}
