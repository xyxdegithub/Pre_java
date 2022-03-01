package com.xyx.controller;

import com.xyx.entity.User;
import com.xyx.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author :xyx
 * @date :2021/4/28 10:34
 * @description:TODO
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/findAll")
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") Integer id) {
        return userMapper.findById(id);
    }

    @GetMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        userMapper.deleteById(id);
        System.out.println("删除成功!");
    }
}
