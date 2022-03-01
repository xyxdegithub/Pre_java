package com.xyx.controller;

import com.xyx.entity.Book;
import com.xyx.entity.BookAdmin;
import com.xyx.entity.Reader;
import com.xyx.service.BookService;
import com.xyx.service.LoginService;
import com.xyx.service.impl.BookServiceImpl;
import com.xyx.service.impl.LoginServiceImpl;


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
 * @date :2021/5/9 18:10
 * @description:登录
 * @
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private LoginService loginService = new LoginServiceImpl();

    private BookService bookService = new BookServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String type = req.getParameter("type");
        System.out.println(type);
        Object object = loginService.login(username, password, type);
        if (object != null) {
            HttpSession session = req.getSession();
            switch (type) {
                case "reader":
                    Reader reader = (Reader) object;
                    //登录的用户存到session中保存
                    session.setAttribute("reader", reader);
                    System.out.println(reader);

                    //解耦合  登录成功默认显示第一页能放下的图书
                    resp.sendRedirect("/bookPage?page=1");
                    break;
                case "admin":
                    BookAdmin bookAdmin = (BookAdmin) object;
                    session.setAttribute("admin", bookAdmin);
                    System.out.println(bookAdmin);
                    //跳转到管理员页面
                    resp.sendRedirect("/admin?page=1");
                    break;
            }
        } else {
            System.out.println("用户名或密码有错误!");
            resp.sendRedirect("login.jsp");
        }

    }
}
