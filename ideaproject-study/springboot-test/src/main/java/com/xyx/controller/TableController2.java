package com.xyx.controller;

import com.xyx.service.impl.CollegeServiceImpl;
import com.xyx.vo.TableDataVO;
import com.xyx.vo.CollegeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :xyx
 * @date :2021/5/9 11:28
 * @description:TODO
 * @
 */
@RestController
public class TableController2 {

    @Autowired
    private CollegeServiceImpl collegeService;

    @RequestMapping("/show")
    public TableDataVO show() {
        TableDataVO<CollegeVO> show = collegeService.show();
        return show;
    }

}

