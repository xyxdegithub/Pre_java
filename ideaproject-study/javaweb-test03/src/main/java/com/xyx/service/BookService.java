package com.xyx.service;

import com.xyx.entity.Book;

import java.util.List;

/**
 * @author :xyx
 * @date :2021/5/10 16:51
 * @description:TODO
 * @
 */
public interface BookService {
    public List<Book> queryAll(int page);

    public int getPages();

    public void BorrowBook(Integer bookId, Integer readerId);

    public List queryAllBorrowedBookByReaderId(int readerId, Integer page);

    public int getBorrowPages(Integer readerId);

    public List queryBorrowedBookByState(Integer state,Integer page);

    public List queryBorrowedBookByState2(Integer state,Integer page);

    public int getBorrowCheckPages(Integer state);

    //管理员审核图书，改变图书的状态
    public void checkBorrowedBook(Integer borrowedBookId,Integer state,Integer adminId);
}
