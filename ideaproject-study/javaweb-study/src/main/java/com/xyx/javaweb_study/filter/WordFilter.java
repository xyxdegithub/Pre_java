package com.xyx.javaweb_study.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author :xyx
 * @date :2021/4/22 11:48
 * @description:TODO
 * @
 */
@WebFilter("/word")
public class WordFilter implements Filter {

    /*jsp->filter（可能有多个filter）->servlet*/
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String search = servletRequest.getParameter("search");

        search = search.replace("敏感词", "***");
        //屏蔽后的存进去,让servlet取
        servletRequest.setAttribute("search",search);
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
