package com.xyx.vo;

import lombok.Data;

import java.util.List;

/**
 * @author :xyx
 * @date :2021/5/9 12:10
 * @description:对应前端
 * @
 */
@Data
public class TableDataVO<T> {
    private Integer code;
    private String msg;
    private Integer count;
    private List<T> data;

}
