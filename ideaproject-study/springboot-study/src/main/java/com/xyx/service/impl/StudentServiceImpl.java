package com.xyx.service.impl;

import com.xyx.entity.Student;
import com.xyx.service.StudentService;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author :xyx
 * @date :2021/4/26 14:48
 * @description:TODO
 * @
 */
/*持久层用的注入注解*/
@Repository
public class StudentServiceImpl implements StudentService {

    private static Map<Integer, Student> studentMap;

    static {
        studentMap = new HashMap<Integer, Student>();//这行代码要写不然报错

        studentMap.put(1, new Student(1, "陈独秀", 38));
        studentMap.put(2, new Student(2, "李大钊", 30));
        studentMap.put(3, new Student(3, "鲁迅", 33));
    }

    @Override
    public Collection<Student> findAll() {
        return studentMap.values();
    }

    @Override
    public Student findById(Integer id) {
        if (studentMap.get(id)!=null){
            return studentMap.get(id);
        }else {
            System.out.println("没有查到");
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        studentMap.remove(id);
        System.out.println("成功删除id为" + id + "的学生");
    }

    @Override
    public void saveOrUpdate(Student student) {
        studentMap.put(student.getId(), student);
    }
}
