package com.xyx.controller;

import com.xyx.entity.Reader;
import com.xyx.service.BookService;
import com.xyx.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author :xyx
 * @date :2021/6/6 0:05
 * @description:TODO
 * @
 */
@WebServlet("/borrowBook")
public class BookBorrowServlet extends HttpServlet {

    private BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //得到图书编号
        String bookidStr = req.getParameter("bookid");
        int bookId = Integer.parseInt(bookidStr);

        //得到存在session中的登录用户信息
        HttpSession session = req.getSession();
        Reader reader = (Reader) session.getAttribute("reader");
        Integer readerId = reader.getId();

        //调用service层,进行借书
        bookService.BorrowBook(bookId, readerId);

        //借完之后展示借阅的书
        resp.sendRedirect("/borrowPage?page=1");


    }
}
