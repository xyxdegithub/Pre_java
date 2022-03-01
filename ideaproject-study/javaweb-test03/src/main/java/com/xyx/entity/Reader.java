package com.xyx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author :xyx
 * @date :2021/5/9 17:57
 * @description:TODO
 * @
 */
@Data
@AllArgsConstructor
public class Reader {

    private Integer id;
    private String username;
    private String password;
    private String name;
    private String tel;
    private String cardId;
    private String gender;

    public Reader(String name, String cardId, String tel) {
        this.name = name;
        this.cardId = cardId;
        this.tel = tel;

    }
}
