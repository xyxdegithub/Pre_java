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
 * @date :2021/6/11 22:34
 * @description:TODO
 * @
 */
@WebServlet("/borrowPage")
public class BorrowPageServlet extends HttpServlet {
    private BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //得到存在session中的登录用户信息
        HttpSession session = req.getSession();
        Reader reader = (Reader) session.getAttribute("reader");
        Integer readerId = reader.getId();
        //得到地址栏传入的page参数
        String pageStr = req.getParameter("page");
        int page = Integer.parseInt(pageStr);

        List list = bookService.queryAllBorrowedBookByReaderId(readerId, page);
        req.setAttribute("list", list);
        req.setAttribute("dataPrePage", 10);
        req.setAttribute("currentPage", page);
        req.setAttribute("pages", bookService.getBorrowPages(readerId));
        req.getRequestDispatcher("borrow.jsp").forward(req, resp);
    }
}
