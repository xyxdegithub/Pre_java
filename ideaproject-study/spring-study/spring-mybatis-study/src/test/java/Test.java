import com.xyx.bean.User;
import com.xyx.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author :xyx
 * @date :2021/3/29 20:34
 * @description:TODO
 * @
 */
public class Test {
    @org.junit.Test
    public void test() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream stream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> userList = userMapper.selectAllUser();
        for(User user:userList) {
            System.out.println(user);
        }
        session.close();
    }
    @org.junit.Test
    //spring和mybatis整合测试
    public  void test2(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper mapper = context.getBean(UserMapper.class);
        List<User> userList = mapper.selectAllUser();
        for(User user:userList){
            System.out.println(user);
        }
    }
}
