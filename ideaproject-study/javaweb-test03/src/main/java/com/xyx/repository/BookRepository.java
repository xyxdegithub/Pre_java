package com.xyx.repository;

import com.xyx.entity.Book;

import java.util.List;

/**
 * @author :xyx
 * @date :2021/5/10 16:52
 * @description:TODO
 * @
 */
public interface BookRepository {
    public List<Book> queryAll(int index,int limit);

    public int getCount();
}
