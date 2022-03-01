package com.xyx.javaweb_study.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author :xyx
 * @date :2021/4/19 15:43
 * @description:用servlet实现验证表单，并把用户名和密码初始化,用了session
 * @
 */
public class CheckServlet extends HttpServlet {
    private String configUsername;
    private String configPassword;

    @Override
    public void init(ServletConfig config) throws ServletException {
        configUsername = config.getInitParameter("username");
        configPassword = config.getInitParameter("password");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
       /* request生命周期请求完成就已经失效*/
       // req.setAttribute("username", username);
        /*用session保存长*/
        HttpSession session = req.getSession();
        session.setAttribute("username",username);

        /*思考：这个做判断，用==怎么就实现不了*/
        if (username.equals(configUsername) && password.equals(configPassword)) {
            resp.sendRedirect("loginSuccess2.jsp");
        } else {
            resp.sendRedirect("login.jsp");
        }
    }
}
