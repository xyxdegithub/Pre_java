package com.xyx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author :xyx
 * @date :2021/5/7 16:37
 * @description:TODO
 * @
 */
@Data
@AllArgsConstructor
public class CollegeTable {
    private Integer rowId;
    private String category;
    private Integer collegeId;
    private String collegeName;
    private Integer score;
    private Integer rank;

}
