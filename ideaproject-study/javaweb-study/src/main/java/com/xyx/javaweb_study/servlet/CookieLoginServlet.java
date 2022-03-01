package com.xyx.javaweb_study.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author :xyx
 * @date :2021/4/20 10:07
 * @description:TODO
 * @
 */
@WebServlet("/cookieLogin")
public class CookieLoginServlet extends HttpServlet {
    private String cUsername = "admin";
    private String cPassword = "123456";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username.equals(cUsername) && password.equals(cPassword)) {
            Cookie cookie = new Cookie("username", cUsername);
            //不退出cookie信息保存的时间，相当与自动退出
            cookie.setMaxAge(60*60*24*7);
            resp.addCookie(cookie);
            resp.sendRedirect("cookie/cookieWelcome.jsp");

        } else {

            resp.sendRedirect("cookie/cookieLogin.jsp");
        }

    }
}
