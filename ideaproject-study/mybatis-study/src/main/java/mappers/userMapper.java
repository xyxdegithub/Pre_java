package mappers;

import entity.User;

import java.util.List;

/**
 * @author :xyx
 * @date :2021/3/25 19:46
 * @description:TODO
 * @
 */
public interface userMapper {
    //显示所有用户数据
    List<User> showAllUser();

    //根据id查找
    User selectUserById(int id);

    //模糊查询
    List<User> selectUserBy(String username);

    //多条件查询
    List<User> selectUserByM(User user);

    //添加user
    int addUser(User user);

    //更新user信息
    int updateUser(User user);

    //根据id删除
    int deleteUserById(int id);
}
