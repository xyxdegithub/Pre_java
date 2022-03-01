package com.xyx.repository;

import com.xyx.entity.BookAdmin;
import com.xyx.entity.Reader;

/**
 * @author :xyx
 * @date :2021/5/9 18:11
 * @description:TODO
 * @
 */
public interface ReaderLoginRepository {
    public Reader login(String username, String password);


}
