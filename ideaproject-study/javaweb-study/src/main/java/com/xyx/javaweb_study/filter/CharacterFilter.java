package com.xyx.javaweb_study.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author :xyx
 * @date :2021/4/22 10:28
 * @description:不用@WebFilter在web.xml文件中要进行配置
 * @
 */
public class CharacterFilter implements Filter {
    public CharacterFilter() {
        System.out.println("tomcat启动就无参方法构造对象");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("tomcat启动就filter初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        // System.out.println("characterFilter过滤");
        //乱码处理后，让继续往后走到servlet去,这行代码必须写
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("tomcat关闭filter销毁");
    }
}
