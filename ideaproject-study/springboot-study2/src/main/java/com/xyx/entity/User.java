package com.xyx.entity;

import lombok.Data;

/**
 * @author :xyx
 * @date :2021/4/28 10:26
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
