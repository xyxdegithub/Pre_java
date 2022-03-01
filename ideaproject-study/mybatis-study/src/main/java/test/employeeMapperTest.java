package test;


import entity.Employee;
import mappers.employeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author :xyx
 * @date :2021/3/24 17:04
 * @description:TODO
 * @
 */
public class employeeMapperTest {
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
    public void after() {
        session.commit();
    }
    public void tsetEmployeeFindAll(){
        employeeMapper mapper = session.getMapper(employeeMapper.class);
        List<Employee> allEmployees = mapper.findAllEmployees();
        for (int i = 0; i < allEmployees.size(); i++) {
            System.out.println(allEmployees.get(i));
        }


    }

    public static void main(String[] args) {
        employeeMapperTest employeeDaoTest = new employeeMapperTest();
        employeeDaoTest.before();
        employeeDaoTest.tsetEmployeeFindAll();
        employeeDaoTest.after();
    }
}
