package cn.tedu.easymall.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter{
	
	String[] patterns={"login","regist","index"};// 放行路径
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// chain 应用了 责任链模式
		// 需求：用户的注册、登录和首页可以直接访问，其他页面需要先登录
		// 查看Session中保存的用户登录状态
		Object user=((HttpServletRequest)req).getSession().getAttribute("user");
		if(user!=null){// 已经登录
			chain.doFilter(req, resp);
			return;
		}
		
		// 获取本次请求的资源路径
		String uri=((HttpServletRequest)req).getRequestURI();
		
		boolean flag=false;// uri中是否包含放行关键字
		for(String pattern:patterns){
			if(uri.contains(pattern)){
				flag=true;
				break;
			}
		}
		
		if(flag){
			chain.doFilter(req, resp); // 过滤器放行
		}else{
			// 重定向到用户登录页面
			((HttpServletResponse)resp).sendRedirect("/EasyMall/user/page/login.jsp");
		}
		
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
