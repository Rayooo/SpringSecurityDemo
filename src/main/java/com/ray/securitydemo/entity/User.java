package com.ray.securitydemo.entity;


import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

/**
 * 用户表
 */
@Entity
@Table(name = "tb_user")
@Data
@Builder
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String userName;

    @Column
    private String password;

}
