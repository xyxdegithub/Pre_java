package com.xyx.service.impl;

import com.xyx.entity.BookAdmin;
import com.xyx.entity.Reader;
import com.xyx.repository.BookAdminLoginRepository;
import com.xyx.repository.ReaderLoginRepository;
import com.xyx.repository.impl.BookAdminLoginRepositoryImpl;
import com.xyx.repository.impl.ReaderLoginRepositoryImpl;
import com.xyx.service.LoginService;

/**
 * @author :xyx
 * @date :2021/5/9 18:04
 * @description:读者和管理员登录业务
 * @
 */
public class LoginServiceImpl implements LoginService {

    private ReaderLoginRepository readerLoginRepository = new ReaderLoginRepositoryImpl();
    private BookAdminLoginRepository bookAdminLoginRepository = new BookAdminLoginRepositoryImpl();

    @Override
    public Object login(String username, String password, String type) {
        Object object = null;
        switch (type) {
            case "reader":

                object = readerLoginRepository.login(username, password);
                break;
            case "admin":

                object = bookAdminLoginRepository.login(username, password);
                break;
        }

        return object;
    }
}
