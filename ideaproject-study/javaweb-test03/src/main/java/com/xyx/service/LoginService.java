package com.xyx.service;

import com.xyx.entity.Reader;

/**
 * @author :xyx
 * @date :2021/5/9 18:02
 * @description:TODO
 * @
 */
public interface LoginService {
    //使用多态
    public Object login(String username, String password, String type);
}
