package com.xyx.Controller;

import com.xyx.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author :xyx
 * @date :2021/4/26 19:37
 * @description:TODO
 * @
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        System.out.println("index");

        return "index";
    }

    @RequestMapping("/index2")
    public String index2(Model model) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "胡适", 26));
        list.add(new Student(2, "胡适之", 26));
        list.add(new Student(3, "陈独秀", 36));
        model.addAttribute("list", list);
        System.out.println("访问了index2.html");
        return "index2";
    }

    @RequestMapping("/index3")
    /*浏览器输入地址执行这个方法，返回index3.html页面，在页面中把name取出*/
    public String index3(Map<String, String> map) {
        map.put("name", "里");
        HashMap<String, Boolean> hashMap = new HashMap<>();
        hashMap.put("judge", true);
        return "index3";
    }

    @RequestMapping("/index4")

    public String index4(Map<String,Boolean> map) {
        map.put("judge", true);
        map.put("judge2",true);
        return "index4";
    }
}
