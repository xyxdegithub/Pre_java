package com.xyx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author :xyx
 * @date :2021/5/8 14:56
 * @description:TODO
 * @
 */
@Data
@AllArgsConstructor
public class College {

    private Integer id;
    private String category;
    private Integer collegeId;
    private String collegeName;
    private Integer score;
    private Integer rank;
}
