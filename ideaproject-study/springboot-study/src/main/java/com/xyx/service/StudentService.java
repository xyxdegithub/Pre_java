package com.xyx.service;

import com.xyx.entity.Student;

import java.util.Collection;

/**
 * @author :xyx
 * @date :2021/4/26 14:50
 * @description:TODO
 * @
 */

public interface StudentService {
    public Collection<Student> findAll();

    public Student findById(Integer id);

    public void deleteById(Integer id);

    public void saveOrUpdate(Student student);

}
