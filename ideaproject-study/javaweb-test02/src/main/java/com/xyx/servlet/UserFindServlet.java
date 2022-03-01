package com.xyx.servlet;

import com.xyx.entity.User;
import com.xyx.service.UserServiceImpl;
import javafx.geometry.Pos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author :xyx
 * @date :2021/5/7 15:35
 * @description:TODO
 * @
 */
@WebServlet("/userFind")
public class UserFindServlet extends HttpServlet {
    private UserServiceImpl userService=new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int i = Integer.parseInt(id);
        User user = userService.findById(i);
        req.setAttribute("user", user);
        req.getRequestDispatcher("user/findShow.jsp").forward(req, resp);
    }
}
