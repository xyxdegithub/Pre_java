package aop1;

import dao.UserDao;

/**
 * @author :xyx
 * @date :2021/3/28 16:50
 * @description:TODO
 * @
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void service() {
        userDao.str();
    }
}
