package com.xyx.javaweb_study.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author :xyx
 * @date :2021/4/22 10:19
 * @description:TODO
 * @
 */
@WebServlet("/form2")
public class Form2Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //交给过滤器统一处理乱码
        //req.setCharacterEncoding("UTF-8");
        String address = req.getParameter("address");
        System.out.println(address);
        resp.sendRedirect("index.jsp");

    }
}
