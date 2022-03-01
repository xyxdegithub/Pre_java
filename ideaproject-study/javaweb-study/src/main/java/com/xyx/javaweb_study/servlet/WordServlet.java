package com.xyx.javaweb_study.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * @author :xyx
 * @date :2021/4/22 11:51
 * @description:TODO
 * @
 */
@WebServlet("/word")
public class WordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = (String) req.getAttribute("search");
        System.out.println(search);

    }
}
