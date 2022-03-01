package com.xyx.service;

import com.xyx.entity.College;
import com.xyx.vo.TableDataVO;
import com.xyx.vo.CollegeVO;

import java.util.List;

/**
 * @author :xyx
 * @date :2021/5/8 16:28
 * @description:TODO
 * @
 */
public interface CollegeService {
    public List<College> showAll();

    public List<College> queryByCollegeName(String name);

    public TableDataVO<CollegeVO> show();
}
