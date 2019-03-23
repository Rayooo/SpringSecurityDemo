package com.ray.securitydemo.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

/**
 * 用户与角色关联表
 */
@Table(name = "tb_user_and_role")
@Entity
@Data
@Builder
public class UserAndRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private Long userId;

    @Column
    private Long roleId;

}
