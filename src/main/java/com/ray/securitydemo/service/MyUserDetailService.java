package com.ray.securitydemo.service;

import com.ray.securitydemo.dao.IRoleDao;
import com.ray.securitydemo.dao.IUserAndRoleDao;
import com.ray.securitydemo.dao.IUserDao;
import com.ray.securitydemo.entity.Role;
import com.ray.securitydemo.entity.UserAndRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IUserAndRoleDao userAndRoleDao;

    @Autowired
    private IRoleDao roleDao;

    /**
     * 从数据库中查询用户
     *
     * @param username 用户名
     * @return UserDetails
     * @throws UsernameNotFoundException 找不到用户抛出该异常
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //用户
        var user = userDao.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username + " not found");
        }

        //用户角色
        var userRoles = userAndRoleDao.findAllByUserId(user.getId());

        var roleIdList = userRoles.stream()
                .map(UserAndRole::getRoleId)
                .collect(Collectors.toList());

        //用户角色列表
        var roleList = roleDao.findAllByIdIn(roleIdList);

        var authorityList = roleList.stream()
                .map(r -> new SimpleGrantedAuthority(r.getRoleName()))
                .collect(Collectors.toList());

        //返回了用户名，密码，权限列表，密码返回交由Security去判断是否正确
        //注意这个User不是我们定义的User，是Security中的User
        return new User(user.getUserName(), user.getPassword(), authorityList);

    }
}
