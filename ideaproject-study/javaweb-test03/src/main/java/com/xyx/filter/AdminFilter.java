package com.xyx.filter;

import com.xyx.entity.BookAdmin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author :xyx
 * @date :2021/6/19 18:02
 * @description:对没有先进行管理员登录，就直接进入管理员页面进行拦截
 * @
 */
@WebFilter("/admin")
public class AdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        BookAdmin admin = (BookAdmin) session.getAttribute("admin");
        if (admin == null) {
            response.sendRedirect("login.jsp");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
