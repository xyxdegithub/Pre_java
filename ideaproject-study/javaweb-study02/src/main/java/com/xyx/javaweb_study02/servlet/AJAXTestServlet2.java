package com.xyx.javaweb_study02.servlet;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xyx.javaweb_study02.entity.Person;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author :xyx
 * @date :2021/4/24 18:45
 * @description:这程序出了什么问题
 * @
 */
@WebServlet("/ajaxtest2")
public class AJAXTestServlet2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");

        Person person = new Person(1, "张三");

        //把java对象变成json字符串
       /* ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(person);
        System.out.println(s);
        resp.getWriter().write(s);*/

        //把java对象变成json对象
        JSONObject jsonObject = JSONObject.fromObject(person);
        resp.getWriter().write(jsonObject.toString());
    }
}
