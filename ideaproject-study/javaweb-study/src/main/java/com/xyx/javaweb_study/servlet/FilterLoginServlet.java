package com.xyx.javaweb_study.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author :xyx
 * @date :2021/4/22 16:11
 * @description:TODO
 * @
 */
@WebServlet("/filterLogin")
public class FilterLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if (name.equals("admin") && password.equals("123456")) {
            /*获取session*/
            HttpSession session = req.getSession();
            session.setAttribute("name", name);
            /*登录成功进入下载页面,filter肯定会进行验证有没有登录*/
            resp.sendRedirect("filter/download.jsp");
        } else {
            /*否则重新登录*/
            resp.sendRedirect("filter/login.jsp");
        }

    }
}
