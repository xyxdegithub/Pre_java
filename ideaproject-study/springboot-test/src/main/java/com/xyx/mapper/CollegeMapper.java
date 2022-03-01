package com.xyx.mapper;

import com.xyx.entity.College;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author :xyx
 * @date :2021/5/8 15:02
 * @description:TODO
 * @
 */
@Mapper
@Repository
public interface CollegeMapper {
    public List<College> showAll();

    public List<College> queryByCollegeName(String name);
}
