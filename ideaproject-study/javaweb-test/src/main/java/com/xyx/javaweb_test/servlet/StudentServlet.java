package com.xyx.javaweb_test.servlet;

import com.xyx.javaweb_test.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author :xyx
 * @date :2021/4/26 17:35
 * @description:TODO
 * @
 */
@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    private static Map<Integer, Student> map;
//设置好静态信息，不是存在数据库中的信息
    static {
        map = new HashMap<>();
        map.put(1, new Student(1, "陈独秀", 36));
        map.put(2, new Student(2, "邓永强", 31));
        map.put(3, new Student(3, "李大钊", 34));
        map.put(4, new Student(4, "胡适", 26));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");


        switch (method) {
            case "showAll":
                req.setAttribute("map", map.values());
                req.getRequestDispatcher("student/index.jsp").forward(req, resp);
                resp.sendRedirect("student/index.jsp");
                break;
            case "delete":
                String id = req.getParameter("id");
                Integer i = Integer.parseInt(id);
                map.remove(i);
                //重定向回查询
                resp.sendRedirect("/student?method=showAll");
                break;
            case "findById":
                String id2 = req.getParameter("id");
                int j = Integer.parseInt(id2);
                Student student = map.get(j);
                req.setAttribute("student", student);
                req.getRequestDispatcher("student/update.jsp").forward(req, resp);

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        int i = Integer.parseInt(id);
        int j = Integer.parseInt(age);
        map.put(i, new Student(i, name, j));
        resp.sendRedirect("/student?method=showAll");

    }
}

