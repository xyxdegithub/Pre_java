package com.xyx.service.impl;

import com.xyx.entity.College;
import com.xyx.mapper.CollegeMapper;
import com.xyx.service.CollegeService;
import com.xyx.vo.TableDataVO;
import com.xyx.vo.CollegeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :xyx
 * @date :2021/5/8 16:28
 * @description:TODO
 * @
 */
@Service
public class CollegeServiceImpl implements CollegeService {
    @Autowired
    private CollegeMapper collegeMapper;

    @Override
    public List<College> showAll() {
        return collegeMapper.showAll();
    }

    @Override
    public List<College> queryByCollegeName(String name) {
        return collegeMapper.queryByCollegeName(name);
    }

    @Override
    /*前后端分离 对应着tablecontroller2*/
    public TableDataVO<CollegeVO> show() {
        TableDataVO tableDataVO = new TableDataVO();
        tableDataVO.setCode(0);
        tableDataVO.setMsg("");
        tableDataVO.setCount(292);

        List<College> collegeList = collegeMapper.showAll();
        List<CollegeVO> collegeVOList = new ArrayList<>();

        for (College college : collegeList) {
            CollegeVO collegeVO = new CollegeVO();
            BeanUtils.copyProperties(college, collegeVO);  //把前面的copy给后面的
            collegeVOList.add(collegeVO);
        }

        tableDataVO.setData(collegeVOList);
        return tableDataVO;
    }
}
