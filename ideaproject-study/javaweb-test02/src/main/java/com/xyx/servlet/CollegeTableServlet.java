package com.xyx.servlet;

import com.xyx.entity.CollegeTable;
import com.xyx.service.CollegeTableImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author :xyx
 * @date :2021/5/7 16:50
 * @description:TODO
 * @
 */
@WebServlet("/scoreTable")
public class CollegeTableServlet extends HttpServlet {
    private CollegeTableImpl collegeTable = new CollegeTableImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CollegeTable> collegeTableList = collegeTable.showAll();
        req.setAttribute("college", collegeTableList);
        req.getRequestDispatcher("table/show.jsp").forward(req, resp);
    }
}
