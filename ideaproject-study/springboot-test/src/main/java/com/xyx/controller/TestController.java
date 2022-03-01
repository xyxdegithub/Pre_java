package com.xyx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :xyx
 * @date :2021/5/8 14:24
 * @description:TODO
 * @
 */
@Controller

public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

}
