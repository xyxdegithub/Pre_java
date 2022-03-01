package com.xyx.service.impl;

import com.xyx.entity.Book;
import com.xyx.repository.BookRepository;
import com.xyx.repository.BorrowRepository;
import com.xyx.repository.impl.BookRepositoryImpl;
import com.xyx.repository.impl.BorrowRepositoryImpl;
import com.xyx.service.BookService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author :xyx
 * @date :2021/5/10 16:51
 * @description:TODO 1 0,10
 * 2 10,20
 * @
 */
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository = new BookRepositoryImpl();
    private BorrowRepository borrowRepository = new BorrowRepositoryImpl();

    //规定每页展示几本书
    private final int bookLimit = 10;

    @Override
    public List<Book> queryAll(int page) {
        int index = (page - 1) * bookLimit;
        List<Book> books = bookRepository.queryAll(index, bookLimit);
        return books;
    }

    @Override
    /**
     * @author:xyx
     * @date:2021/6/11 22:07
     * @description:计算得到图书总共分成几页展示
     */
    public int getPages() {
        int count = bookRepository.getCount();
        if (count % bookLimit == 0) {
            return count / bookLimit;
        } else {
            return (count / bookLimit) + 1;
        }
    }

    @Override
    public void BorrowBook(Integer bookId, Integer readerId) {
        //借书的时间
        Date borrowDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String borrowStr = simpleDateFormat.format(borrowDate);
        System.out.println(borrowStr);
        //最迟的还书时间 使用calendar工具类计算日期
        Calendar calendar = Calendar.getInstance();
        //设置具体借书时间，设置了可借最多60天
        calendar.set(Calendar.DAY_OF_YEAR, (calendar.get(Calendar.DAY_OF_YEAR) + 60));
        Date returnDate = calendar.getTime();
        String returnStr = simpleDateFormat.format(returnDate);
        System.out.println(returnStr);
        //调持久层与数据库交互
        borrowRepository.borrowBook(bookId, readerId, borrowStr, returnStr, null, 0);


    }

    @Override
    public int getBorrowPages(Integer readerId) {
        int count = borrowRepository.getCount(readerId);
        if (count % bookLimit == 0) {
            return count / bookLimit;
        } else {
            return (count / bookLimit) + 1;
        }
    }

    @Override
    public List queryAllBorrowedBookByReaderId(int readerId, Integer page) {
        int index = (page - 1) * bookLimit;
        return borrowRepository.queryAllBorrowedBookByReaderId(readerId, index, bookLimit);
    }

    @Override
    public List queryBorrowedBookByState(Integer state, Integer page) {
        int index = (page - 1) * bookLimit;
        return borrowRepository.queryBorrowedBookByState(state, index, bookLimit);
    }

    @Override
    public List queryBorrowedBookByState2(Integer state, Integer page) {
        int index = (page - 1) * bookLimit;
        return borrowRepository.queryBorrowedBookByState2(state, index, bookLimit);
    }

    @Override
    public int getBorrowCheckPages(Integer state) {
        int count = borrowRepository.getCountAdminCheck(state);
        if (count % bookLimit == 0) {
            return count / bookLimit;
        } else {
            return (count / bookLimit) + 1;
        }
    }

    @Override
    public void checkBorrowedBook(Integer borrowedBookId, Integer state, Integer adminId) {
        borrowRepository.checkBorrowedBook(borrowedBookId, state, adminId);
    }
}
