package cn.tedu.easymall.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.easymall.service.UserService;

@WebServlet("/checkUsername")
public class CheckUsernameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String username=request.getParameter("uname");
		
		boolean flag=UserService.getInstance().hasUsername(username);
		
		if(flag==true){
			response.getWriter().write("yes");
		}else{
			response.getWriter().write("no");
		}
	}

}




