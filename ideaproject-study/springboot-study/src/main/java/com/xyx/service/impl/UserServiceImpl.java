package com.xyx.service.impl;

import com.xyx.entity.User;
import com.xyx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author :xyx
 * @date :2021/4/27 15:24
 * @description:TODO
 * @
 */
@Repository
public class UserServiceImpl implements UserService {

    /*使用JdbcTemplate模板进行数据库操作*/
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() {

        return jdbcTemplate.query("select * from user",
                new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public void add(User user) {
        jdbcTemplate.update
                ("insert into user(id,name,password,email,birthday) values(?,?,?,?,?)",
                        user.getId(), user.getName(), user.getPassword(), user.getEmail(), user.getBirthday());
    }

    @Override
    public void deleteById(Integer id) {
        jdbcTemplate.update("delete  from user where id=?", id);
    }

    @Override
    public void update(User user) {

    }
}
