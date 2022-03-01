package com.xyx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author :xyx
 * @date :2021/3/31 14:34
 * @description:TODO
 * @
 */
@Controller
public class HelloController2 {

@RequestMapping("/hello2")
    public String test(Model model){
        model.addAttribute("msg","Hello SpringMvc2!");
                return "hello";
    }

}
