package com.xyx.repository;

import com.xyx.entity.AdminCheckBorrow;
import com.xyx.entity.vo.BorrowedBook;

import java.util.List;

/**
 * @author :xyx
 * @date :2021/6/6 0:29
 * @description:TODO
 * @
 */
public interface BorrowRepository {
    public void borrowBook(Integer bookId, Integer readerId, String borrowDate,
                           String returnDate, Integer adminId, Integer state);

    //用实体试图封装
    public List<BorrowedBook> queryAllBorrowedBookByReaderId(Integer readerId, Integer index, Integer limit);

    //得到borrow表中的记录数,根据读者的id进行查
    public int getCount(Integer readerId);

    public List<AdminCheckBorrow> queryBorrowedBookByState(Integer state, Integer index, Integer limit);

    public List<BorrowedBook> queryBorrowedBookByState2(Integer state, Integer index, Integer limit);

    public int getCountAdminCheck(Integer state);

    //与数据库进行数据的交互，更新管理员操作后所借图书的状态
    public void checkBorrowedBook(Integer borrowedBookId, Integer state, Integer adminId);
}
