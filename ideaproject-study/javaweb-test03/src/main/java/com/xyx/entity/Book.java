package com.xyx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author :xyx
 * @date :2021/5/9 22:19
 * @description:TODO
 * @
 */
@Data
@AllArgsConstructor
public class Book {
    private Integer id;
    private String name;
    private String author;
    private String publish;
    private Integer pages;
    private double price;
    private BookCase bookCase;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }
}
