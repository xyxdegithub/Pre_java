package com.xyx.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author :xyx
 * @date :2021/4/27 15:19
 * @description:TODO
 * @
 */
@Data
public class User {

    private Integer id;
    private String name;
    private String password;
    private String email;
    private String birthday;
}
