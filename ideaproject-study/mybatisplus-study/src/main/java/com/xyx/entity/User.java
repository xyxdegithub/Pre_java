package com.xyx.entity;

import lombok.Data;

/**
 * @author :xyx
 * @date :2021/7/17 6:39
 * @description:根据类名去数据库查找，也可以加上@Tablename注解查找
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
