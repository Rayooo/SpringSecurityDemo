package com.ray.securitydemo.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 角色表
 */
@Entity
@Table(name = "tb_role")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String roleName;


}
