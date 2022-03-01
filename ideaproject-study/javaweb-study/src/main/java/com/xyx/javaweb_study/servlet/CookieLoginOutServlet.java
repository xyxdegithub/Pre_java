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
 * @date :2021/4/20 10:40
 * @description:TODO
 * @
 */
@WebServlet("/cookieLoginOut")
public class CookieLoginOutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")) {
                cookie.setMaxAge(0);
                //加上才有效,退出cookie信息就失效
                resp.addCookie(cookie);
                resp.sendRedirect("cookie/cookieLogin.jsp");
            }
        }

    }
}
