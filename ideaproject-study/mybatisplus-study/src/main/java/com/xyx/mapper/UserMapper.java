package com.xyx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xyx.entity.User;

/**
 * @author :xyx
 * @date :2021/7/17 6:41
 * @description:继承一个类就行，没有具体的方法，也不需要像mybatis一样写xml文件
 * @
 */
public interface UserMapper extends BaseMapper<User> {
}


