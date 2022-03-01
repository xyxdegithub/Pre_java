package com.xyx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author :xyx
 * @date :2021/3/31 8:48
 * @description:TODO
 * @
 */
@Controller

public class HelloController {

@RequestMapping("/hello")
    public String sayHello(Model model) {

        model.addAttribute("msg", "Hello SpringMvc!");

        return "hello";    //WEB-INF/jsp/hello.jsp
    }

}
