package cn.my.web.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.my.web.dao.DBUtilDAO;
import cn.my.web.entity.User;
import cn.my.web.util.DBUtil;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//设置编码
		response.setContentType("text/html;charset=utf-8");
		boolean flag;
		String id=request.getParameter("id");
		String username=request.getParameter("username");//获取参数
		String password=request.getParameter("password");
		String email=request.getParameter("email");//获取参数
		String phone=request.getParameter("phone");
		User u=new User(null,username,password,email,phone);
		if(flag=DBUtilDAO.insert(u)){
		System.out.println(u);
		response.sendRedirect("/mywebproject/login.jsp");
	}
	}

}
