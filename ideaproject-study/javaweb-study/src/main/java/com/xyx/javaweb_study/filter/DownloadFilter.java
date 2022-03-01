package com.xyx.javaweb_study.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author :xyx
 * @date :2021/4/22 15:31
 * @description:TODO
 * @
 */
@WebFilter("/filter/download.jsp")
public class DownloadFilter implements Filter {
    /*不登录就直接进入下载页面会被拦截*/

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //强制装换到子类,用子类的getsession方法和其他方法
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        /*获取session*/
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        if (name == null) {
            response.sendRedirect("/filter/login.jsp");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }
}
