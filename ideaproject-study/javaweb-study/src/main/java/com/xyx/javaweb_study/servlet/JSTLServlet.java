package com.xyx.javaweb_study.servlet;

import com.xyx.javaweb_study.entiry.Student;
import com.xyx.javaweb_study.entiry.Address;
import sun.security.jgss.HttpCaller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author :xyx
 * @date :2021/4/21 19:45
 * @description:TODO
 * @
 */
@WebServlet("/JSTL")
public class JSTLServlet extends HttpServlet {
    /*先访问servlet后再jsp中用jstl取*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "xx", 100, new Address("yy")));
        students.add(new Student(2, "yy", 100, new Address("xx")));
        /*先存再用EL表达式取*/
        req.setAttribute("students", students);
        req.getRequestDispatcher("JSTL/jstl.jsp").forward(req, resp);
        /*resp.sendRedirect("/JSTL");*/
    }
}
