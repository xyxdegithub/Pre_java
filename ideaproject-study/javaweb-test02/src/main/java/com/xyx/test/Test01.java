package com.xyx.test;

import com.xyx.entity.User;
import com.xyx.service.UserServiceImpl;

import java.util.List;

/**
 * @author :xyx
 * @date :2021/5/1 16:47
 * @description:TODO
 * @
 */
public class Test01 {

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        List<User> all = userService.findAll();
        System.out.println(all);
    }
}
