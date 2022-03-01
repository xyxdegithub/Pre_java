package com.xyx.javaweb_study.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author :xyx
 * @date :2021/4/13 9:46
 * @description:TODO
 * @
 */
@WebServlet("/myservlet")
public class MyServlet implements Servlet {


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html;charset=utf-8");
        PrintWriter writer = servletResponse.getWriter();
        writer.println("你好这里是MyServlet!");
        /*获取客户端传来的参数*/
        String id = servletRequest.getParameter("id");
        writer.println(id);

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
