package com.xyx.controller;

import com.xyx.entity.College;
import com.xyx.mapper.CollegeMapper;
import com.xyx.service.CollegeService;
import com.xyx.service.impl.CollegeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author :xyx
 * @date :2021/5/8 14:37
 * @description:TODO
 * @
 */
@Controller
@RequestMapping("/table")
public class TableController {

    @Autowired
    private CollegeServiceImpl collegeServiceImpl;

    @RequestMapping("/show")
    public String show(Model model) {
        List<College> collegeList = collegeServiceImpl.showAll();
        model.addAttribute("list", collegeList);
        return "toudangbiao/show";
    }

    @RequestMapping("/queryByName")
    //使用注解获得表单的值
    public String queryByName(Model model, @RequestParam("name") String name) {
        System.out.println(name);
        List<College> collegeList = collegeServiceImpl.queryByCollegeName(name);
        model.addAttribute("list", collegeList);
        return "toudangbiao/show";
    }

}
