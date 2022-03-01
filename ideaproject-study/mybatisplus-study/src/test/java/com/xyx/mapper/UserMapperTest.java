package com.xyx.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xyx.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author :xyx
 * @date :2021/7/17 6:45
 * @description:TODO
 * @
 */
@SpringBootTest
class UserMapperTest {

    //一定要把这对象注入容器，否则会报空指针
    @Autowired
    private UserMapper userMapper;

    @Test
    public void Test() {
        userMapper.selectList(null).forEach(System.out::println);

    }
}