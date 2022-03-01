package cn.tedu.easymall.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.easymall.entity.User;
import cn.tedu.easymall.service.UserService;

public class RegistServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 解决请求乱码问题
		req.setCharacterEncoding("utf-8");
		// 获取请求参数
		String username=req.getParameter("uname");
		String password=req.getParameter("upwd");
		String rePassword=req.getParameter("repwd");
		String email=req.getParameter("email");
		String phone=req.getParameter("phone");
		// 将数据封装成User对象
		User user=new User(null, username, password, email, phone);
		System.out.println(user);
		// 调用service方法执行注册操作
		boolean flag=UserService.getInstance().regist(user);
		if(flag){//注册成功
			resp.sendRedirect("/EasyMall/user/page/login.jsp");
		}
		
	}
}




