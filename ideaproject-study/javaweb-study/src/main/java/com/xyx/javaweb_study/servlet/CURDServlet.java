package com.xyx.javaweb_study.servlet;

import com.sun.xml.internal.ws.wsdl.writer.document.StartWithExtensionsType;
import com.xyx.javaweb_study.entiry.Person;

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
 * @date :2021/4/21 14:49
 * @description:curd逻辑操作
 * @
 */
@WebServlet("/curd")
public class CURDServlet extends HttpServlet {
    //声明变量
    private static Map<Integer, Person> map = new HashMap<Integer, Person>();

    static {
        map.put(1701, new Person(1701, "Bob", 10, 150));
        map.put(1702, new Person(1702, "Alice", 17, 160));
        map.put(1703, new Person(1703, "Rose", 19, 170));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
      /*  String method = req.getParameter("method");
        if (method == null) {
            method = "save";
        }
        switch (method) {
            case "save":
                String id = req.getParameter("id");
                String name = req.getParameter("name");
                String age = req.getParameter("age");
                String height = req.getParameter("height");
                int i = Integer.parseInt(id);
                int a = Integer.parseInt(age);
                int h = Integer.parseInt(height);
                Person person = new Person(i, name, a, h);
                map.put(i, person);
                resp.sendRedirect("/curd");
                break;
            case "update":
                id = req.getParameter("id");
                name = req.getParameter("name");
                age = req.getParameter("age");
                height = req.getParameter("height");
                i = Integer.parseInt(id);
                a = Integer.parseInt(age);
                h = Integer.parseInt(height);
                person = new Person(i, name, a, h);
                map.put(i, person);
                resp.sendRedirect("/curd");
                break;
        }*/
        /*以上两个方法都是保存用户本质一样，简化代码，不用这么控制选择*/
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String height = req.getParameter("height");
        int i = Integer.parseInt(id);
        int a = Integer.parseInt(age);
        int h = Integer.parseInt(height);
        Person person = new Person(i, name, a, h);
        map.put(i, person);
        //重定向/curd进入doget方法（刷新可见）
        resp.sendRedirect("/curd");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method == null) {
            method = "showAll";
        }

        switch (method) {
            case "delete":
                String id = req.getParameter("id");
                int i = Integer.parseInt(id);
                map.remove(i);
                /*经典动作*/
                resp.sendRedirect("/curd?method=showAll");
                break;
            case "showAll":
                req.setAttribute("map", map.values());
                req.getRequestDispatcher("case/show.jsp").forward(req, resp);
                break;
            case "findById":
                id = req.getParameter("id");
                i = Integer.parseInt(id);
                Person person = map.get(i);
                req.setAttribute("person", person);
                req.getRequestDispatcher("case/update.jsp").forward(req, resp);
                break;

        }

    }
}
