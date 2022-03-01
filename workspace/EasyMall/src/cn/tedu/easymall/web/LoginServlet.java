package cn.tedu.easymall.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.tedu.easymall.entity.User;
import cn.tedu.easymall.service.UserService;


public class LoginServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 通知Tomcat使用utf-8对请求参数进行解码
		req.setCharacterEncoding("utf-8");
		// 获取请求参数
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		// 后台表单验证
		if(username==null || username.length()==0){
			req.setAttribute("errmsg", "用户名不能为空！");
			req.getRequestDispatcher("/user/page/login.jsp").forward(req, resp);
			return;// 让后面的代码不再执行
		}
		if(password==null || password.length()==0){
			req.setAttribute("errmsg", "密码不能为空！");
			req.getRequestDispatcher("/user/page/login.jsp").forward(req, resp);
			return;
		}
		if( password.length()<6 || password.length()>15){
			req.setAttribute("errmsg", "密码长度为6-15位");
			req.getRequestDispatcher("/user/page/login.jsp").forward(req, resp);
			return;
		}
		
		// 调用Service方法执行登录逻辑
		User user=UserService.getInstance().login(username, password);
		// 将user对象保存到Session中
		HttpSession session=req.getSession(); // 获取Session对象
		session.setAttribute("user", user); // 将user对象存入Session中
		
		if(user!=null){// 登录成功
			resp.sendRedirect("/EasyMall/user/page/index.html");
		}else{
			req.setAttribute("errmsg", "用户名或密码错误！");
			req.getRequestDispatcher("/user/page/login.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
	
	

}
