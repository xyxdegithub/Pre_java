package com.xyx.service;

import com.xyx.entity.User;

import java.util.List;

/**
 * @author :xyx
 * @date :2021/4/27 15:21
 * @description:TODO
 * @
 */
public interface UserService {
    public List<User> findAll();

    public User findById(Integer id);

    public void add(User user);

    public void deleteById(Integer id);

    public void update(User user);
}
