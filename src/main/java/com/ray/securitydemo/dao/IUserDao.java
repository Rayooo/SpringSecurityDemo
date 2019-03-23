package com.ray.securitydemo.dao;


import com.ray.securitydemo.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserDao extends CrudRepository<User, Long> {

    User findByUserName(String userName);


}
