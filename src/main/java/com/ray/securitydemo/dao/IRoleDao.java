package com.ray.securitydemo.dao;

import com.ray.securitydemo.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface IRoleDao extends CrudRepository<Role, Long> {

    List<Role> findAllByIdIn(List<Long> idList);


}
