package com.xyx.javaweb_study.entiry;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author :xyx
 * @date :2021/4/21 14:51
 * @description:TODO
 * @
 */
@Data
@AllArgsConstructor
public class Person {
    private Integer id;
    private String name;
    private Integer age;
    private Integer height;


}
