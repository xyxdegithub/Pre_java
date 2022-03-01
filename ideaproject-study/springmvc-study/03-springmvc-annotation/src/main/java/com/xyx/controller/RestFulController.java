package com.xyx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.misc.Contended;

/**
 * @author :xyx
 * @date :2021/3/31 14:46
 * @description:TODO
 * @
 */
@Controller
public class RestFulController {
    @RequestMapping("/add/{a}/{b}")
    public String add(@PathVariable int a,@PathVariable int b, Model model) {
        int sum = a + b;
        model.addAttribute("msg", sum);
        return "hello";
    }
}
