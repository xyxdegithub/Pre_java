package com.xyx.controller;

import com.xyx.entity.Book;
import com.xyx.service.BookService;
import com.xyx.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author :xyx
 * @date :2021/6/1 19:31
 * @description:写代码不要贪快，特别对一些方法参数不熟时
 * @
 */
@WebServlet("/bookPage")
public class BookPageServlet extends HttpServlet {

    private BookService bookService = new BookServiceImpl();

    @Override
  /**
   * @author:xyx
   * @date:2021/6/5 23:59
   * @description:下面的方法是查询图书分页展示
   */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageStr = req.getParameter("page");
        int page = Integer.parseInt(pageStr);
        System.out.println("第" + page + "页");

        //查询所有图书返回在一个list集合中
        List<Book> books = bookService.queryAll(page);
        req.setAttribute("list", books);

        req.setAttribute("dataPrePage", 10);
        req.setAttribute("currentPage", page);
        req.setAttribute("pages", bookService.getPages());

        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }
}
