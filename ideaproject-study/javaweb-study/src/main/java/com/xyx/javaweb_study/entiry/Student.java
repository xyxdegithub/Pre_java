package com.xyx.javaweb_study.entiry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author :xyx
 * @date :2021/4/20 15:33
 * @description:TODO
 * @
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Integer Id;
    private String name;
    private Integer score;
    private Address address;
}
