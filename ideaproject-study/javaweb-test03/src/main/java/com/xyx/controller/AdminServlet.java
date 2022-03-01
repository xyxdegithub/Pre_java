package com.xyx.controller;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xyx.entity.BookAdmin;
import com.xyx.entity.vo.BorrowedBook;
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
 * @date :2021/6/17 18:35
 * @description:管理员的相关操作
 * @
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    private BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        HttpSession session = req.getSession();
        BookAdmin admin = (BookAdmin) session.getAttribute("admin");
        if (method == null) {
            method = " ";
        }
        switch (method) {
            case " ":
                String pageStr = req.getParameter("page");
                int page = Integer.parseInt(pageStr);

                List list = bookService.queryBorrowedBookByState(0, page);
                //管理员页面只显示state为0，就是为审核的书籍
                req.setAttribute("list", list);
                req.setAttribute("dataPrePage", 10);
                req.setAttribute("currentPage", page);
                req.setAttribute("pages", bookService.getBorrowCheckPages(0));
                req.getRequestDispatcher("admin.jsp").forward(req, resp);
                break;
            case "check":
                String idStr = req.getParameter("id");
                String stateStr = req.getParameter("state");
                int id = Integer.parseInt(idStr);
                int state = Integer.parseInt(stateStr);
                //调用业务层执行
                bookService.checkBorrowedBook(id, state, admin.getId());
                //执行完毕后，刷新页面得到最新结果
                if (state == 1 || state == 2) {
                    resp.sendRedirect("/admin?page=1");
                }
                if (state == 3) {
                    resp.sendRedirect("/admin?method=getCheckedBorrowed&page=1");
                }
                break;
            case "getCheckedBorrowed":
                pageStr = req.getParameter("page");
                page = Integer.parseInt(pageStr);
                List<BorrowedBook> borrowedBooks = bookService.queryBorrowedBookByState2(1, page);
                System.out.println(borrowedBooks);
                req.setAttribute("list", borrowedBooks);
                req.setAttribute("dataPrePage", 10);
                req.setAttribute("currentPage", page);
                req.setAttribute("pages", bookService.getBorrowCheckPages(1));
                req.getRequestDispatcher("/return.jsp").forward(req, resp);
                break;
        }

    }
}
