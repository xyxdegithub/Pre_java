package com.xyx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author :xyx
 * @date :2021/6/17 18:39
 * @description:TODO
 * @
 */
@Data
@AllArgsConstructor
public class AdminCheckBorrow {

    private Integer id;
    private Book book;
    private Reader reader;
    private String borrowTime;
    private String returnTime;

}
