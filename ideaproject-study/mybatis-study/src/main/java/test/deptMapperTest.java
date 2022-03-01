package test;


import entity.Dept;
import mappers.deptMapper;
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
public class deptMapperTest {
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

    public void testFindDeptById() {
        deptMapper mapper = session.getMapper(deptMapper.class);
        Dept deptById = mapper.findDeptById(1);
        System.out.println(deptById);

    }
    public void testFindAllDept(){
        deptMapper mapper = session.getMapper(deptMapper.class);
        List<Dept> allDept = mapper.findAllDept();
       /* for (int i = 0; i < allDept.size(); i++) {
            System.out.println(allDept.get(i));
        }*/
        System.out.println(allDept);


    }

    public static void main(String[] args) {
        deptMapperTest employeeDaoTest = new deptMapperTest();
        employeeDaoTest.before();
        employeeDaoTest.testFindDeptById();
        System.out.println("*********************************");
        employeeDaoTest.testFindAllDept();
        employeeDaoTest.after();
    }
}
