package com.xyx.servlet;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.xyx.entity.User;
import com.xyx.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :xyx
 * @date :2021/5/1 17:16
 * @description:TODO
 * @
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
    //private UserService UserService;
    private UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        String id = req.getParameter("id");
        switch (method) {
            case "showAll":
                /*展示所有用户*/
                List<User> all = userService.findAll();
                req.setAttribute("all", all);
                req.getRequestDispatcher("user/show.jsp").forward(req, resp);
                break;
            case "delete":
                int id1 = Integer.parseInt(id);
                userService.deleteById(id1);
                resp.sendRedirect("/user?method=showAll");
                break;

        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        switch (method) {
            case "add":
                String id = req.getParameter("id");
                String name = req.getParameter("name");
                String age = req.getParameter("age");
                int i = Integer.parseInt(id);
                int i1 = Integer.parseInt(age);
                userService.addUser(i, name, i1);
                resp.sendRedirect("/user?method=showAll");
                break;
        }
    }

}
