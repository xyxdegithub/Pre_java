package com.xyx.javaweb_study02.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author :xyx
 * @date :2021/4/25 9:26
 * @description:ajax传json对象怎么就失败的，之间是什么问题
 * @
 */
@WebServlet("/test")
public class TestServlet extends HttpServlet {

    private static Map<String, List<String>> provinceMap;
    private static Map<String, List<String>> cityMap;

    static {
        List<String> provinceList = new ArrayList<String>();

        provinceList.add("赣州市");
        provinceList.add("南昌市");
        provinceMap.put("0", provinceList);
        provinceList = new ArrayList<>();
        provinceList.add("广州市");
        provinceList.add("深圳市");
        provinceMap.put("1", provinceList);

        List<String> cityList = new ArrayList<String>();
        cityList.add("章贡区");
        cityList.add("南康区");
        cityMap.put("0-1", cityList);
        cityList = new ArrayList<>();
        cityList.add("红谷滩区");
        cityList.add("东湖区");
        cityMap.put("0-0", cityList);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        String type = req.getParameter("type");
        String id = req.getParameter("id");
        switch (type) {
            case "province":
                List<String> citys = provinceMap.get(id);
                /*JSONArray jsonArray = JSONArray.fromObject(citys);
                resp.getWriter().write(jsonArray.toString());*/
                ObjectMapper objectMapper = new ObjectMapper();
                String s = objectMapper.writeValueAsString(citys);
                resp.getWriter().write("s");
                System.out.println(s);
                break;
            case "city":
                break;
        }

    }
}
