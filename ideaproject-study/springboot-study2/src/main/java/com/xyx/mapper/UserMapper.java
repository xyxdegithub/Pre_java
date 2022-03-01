package com.xyx.mapper;

import com.xyx.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author :xyx
 * @date :2021/4/28 10:32
 * @description:TODO
 * @
 */

public interface UserMapper {

    public List<User> findAll();

    public User findById(Integer id);

    public void deleteById(Integer id);
}
