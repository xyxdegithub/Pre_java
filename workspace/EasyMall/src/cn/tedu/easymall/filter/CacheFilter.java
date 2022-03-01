package cn.tedu.easymall.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/user/page/*")
public class CacheFilter implements Filter {
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 设置响应头，通知浏览器不缓存本次响应内容
		HttpServletResponse resp=(HttpServletResponse)response;
		resp.setHeader("pragma", "no-cache"); // http1.0版
		resp.setHeader("cache-control", "no-store"); // http1.1版
		chain.doFilter(request, response);
	}

	public void destroy() {
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
