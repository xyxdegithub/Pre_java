package com.xyx.Controller;

import com.xyx.entity.Student;
import com.xyx.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author :xyx
 * @date :2021/4/26 14:53
 * @description:TODO
 * @
 */
@RestController
/*用来返回字符串*/
@RequestMapping("/student")
public class StudentController {
    @Autowired
    /*把java对象注入*/
    private StudentService studentService;

    /*一般用RequestMapping*/
    /*可以用postman软件测试,可以用get，post，delete，put多种请求方式*/

    @GetMapping("/findAll")
    public Collection<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") Integer id) {
        return studentService.findById(id);
    }

    /*@GetMapping("/save")
    public void save(@RequestBody Student student) {
        studentMapper.saveOrUpdate(student);
    }
保存更新需要。。。
    @GetMapping("/update")
    public void update(@RequestBody Student student) {
        studentMapper.saveOrUpdate(student);

    }*/

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") Integer id) {
        studentService.deleteById(id);
        return "删除成功";
    }
}
