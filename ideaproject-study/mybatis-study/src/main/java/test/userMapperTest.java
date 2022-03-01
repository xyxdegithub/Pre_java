package test;

import entity.User;
import mappers.userMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author :xyx
 * @date :2021/3/25 19:56
 * @description:TODO
 * @
 */
public class userMapperTest {

    private SqlSession session;

    public void before() {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            session = sqlSessionFactory.openSession();


        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }

    public void testShowAllUser() {
        userMapper mapper = session.getMapper(userMapper.class);
        List<User> allusers = mapper.showAllUser();
        System.out.println(allusers);
    }

    public void testSelectUserById(int id) {

        userMapper mapper = session.getMapper(userMapper.class);
        User user = mapper.selectUserById(id);
        System.out.println(user);

    }
    //
    public void testSelectBy() {
        userMapper mapper = session.getMapper(userMapper.class);
        String name="%哥%";
        List<User> users = mapper.selectUserBy(name);
        System.out.println(users);
    }

    public void testSelectUserByM(){
        userMapper mapper = session.getMapper(userMapper.class);
        User user = new User(null, "", "123456");
        List<User> users = mapper.selectUserByM(user);
        System.out.println(users);
    }

    public void testAddUser() {
        userMapper mapper = session.getMapper(userMapper.class);
        User user = new User(3, "宋江", "123");
        int affectedRows = mapper.addUser(user);
        if (affectedRows == 1) {
            System.out.println("添加成功!");
        }


    }

    public void testUpdateUser() {
        userMapper mapper = session.getMapper(userMapper.class);
        User user = new User(4, "宋江", "123");
        int affectedRows = mapper.addUser(user);
        if (affectedRows == 1) {
            System.out.println("更新成功!");
        }
    }

    public void testDeleteUser(int id) {
        userMapper mapper = session.getMapper(userMapper.class);
        int affectedRows = mapper.deleteUserById(id);
        if (affectedRows == 1) {
            System.out.println("删除成功!");
        }

    }

    public void after() {
        session.commit();
    }


    public static void main(String[] args) {
        userMapperTest userDaoTest = new userMapperTest();
        userDaoTest.before();
        //userDaoTest.testDeleteUser(3);
        //userDaoTest.testShowAllUser();
        userDaoTest.testSelectBy();
        userDaoTest.testSelectUserByM();
        userDaoTest.after();
    }
}


