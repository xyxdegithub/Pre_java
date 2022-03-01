package com.xyx.javaweb_study.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author :xyx
 * @date :2021/4/14 14:42
 * @description:TODO
 * @
 */

public class TestServlet implements Servlet {


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        String servletName = servletConfig.getServletName();
        System.out.println("初始化了" + servletName);
        
        /*获取初始化参数信息，在xml里要配置，基于注解用不了*/
        String value = servletConfig.getInitParameter("value");
        System.out.println(value);
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String str=initParameterNames.nextElement();
            System.out.println(str);
        }
        ServletContext servletContext = servletConfig.getServletContext();
        System.out.println(servletContext);

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("这里是service()方法");
    }

    @Override
    public String getServletInfo() {

        return null;
    }

    @Override
    public void destroy() {
        System.out.println("这里是destroy()方法");
    }
}
