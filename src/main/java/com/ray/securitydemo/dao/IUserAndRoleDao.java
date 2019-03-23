package com.ray.securitydemo.dao;

import com.ray.securitydemo.entity.UserAndRole;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IUserAndRoleDao extends CrudRepository<UserAndRole, Long> {

    List<UserAndRole> findAllByUserId(Long userId);

}
