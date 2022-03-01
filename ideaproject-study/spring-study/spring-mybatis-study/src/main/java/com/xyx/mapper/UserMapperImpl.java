package com.xyx.mapper;

import com.xyx.bean.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

/**
 * @author :xyx
 * @date :2021/3/30 9:34
 * @description:TODO
 * @
 */
public class UserMapperImpl implements UserMapper {

    //sqlSession不用我们自己创建了，Spring来管理
    private SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<User> selectAllUser() {
        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        return mapper.selectAllUser();

    }
}
