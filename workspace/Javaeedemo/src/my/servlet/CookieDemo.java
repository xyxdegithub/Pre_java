package my.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		//查询所有cookie信息
		Cookie[] cookies = req.getCookies();
		if(cookies != null){
			for(int i = 0 ; i < cookies.length ; i++){
				String name = cookies[i].getName();
				if(name.equals("product")){
					out.println("您上次浏览商品为：" + cookies[i].getValue());
					break;
				}
			}
		}else{
			out.println("No cookie.");
			Cookie cookie=new Cookie("product" , "IPhone7");
			cookie.setMaxAge(60*60);
			resp.addCookie(cookie);
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
