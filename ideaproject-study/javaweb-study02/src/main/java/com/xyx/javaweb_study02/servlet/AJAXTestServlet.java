package com.xyx.javaweb_study02.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author :xyx
 * @date :2021/4/24 10:29
 * @description:TODO
 * @
 */
@WebServlet("/ajaxtest")
public class AJAXTestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
       /* try {
            Thread.sleep(3000);
            String str="Hello";
            req.setAttribute("str",str);
            req.getRequestDispatcher("ajax/ajaxtest.jsp").forward(req,resp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        String text = req.getParameter("elementById");
        System.out.println(text);
        resp.getWriter().write(text);

    }
}
