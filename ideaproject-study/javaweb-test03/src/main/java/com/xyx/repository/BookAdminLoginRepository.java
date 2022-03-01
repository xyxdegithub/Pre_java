package com.xyx.repository;

import com.xyx.entity.BookAdmin;

/**
 * @author :xyx
 * @date :2021/5/9 19:45
 * @description:TODO
 * @
 */
public interface BookAdminLoginRepository {
    public BookAdmin login(String username,String password);
}
