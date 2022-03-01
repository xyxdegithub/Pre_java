package com.xyx.javaweb_study.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author :xyx
 * @date :2021/4/22 10:18
 * @description:TODO
 * @
 */
@WebServlet("/form")
public class FormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //交给过滤器统一处理乱码
        //req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        System.out.println(name);
        resp.sendRedirect("filter/form2.jsp");

    }
}
