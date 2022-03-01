package mappers;

import entity.Dept;

import java.util.List;

/**
 * @author :xyx
 * @date :2021/3/25 19:51
 * @description:TODO
 * @
 */
public interface deptMapper {
    Dept findDeptById(int id);
    List<Dept> findAllDept();
}
