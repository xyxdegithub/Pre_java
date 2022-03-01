package cn.tedu.easymall.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.tedu.easymall.entity.User;
import cn.tedu.easymall.service.UserService;


@WebServlet("/changePwd")
public class ChangePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 解决请求乱码
		
		// 1. 获取请求参数
		String upwd=request.getParameter("upwd");
		String npwd=request.getParameter("npwd");
		String cpwd=request.getParameter("cpwd");
		
		// 解决响应乱码
		response.setContentType("text/html;charset=utf-8");
		
		// 2. 表单验证
		// 非空验证
		if(upwd==null||upwd.length()==0){
			response.getWriter().write("原始密码不能为空");
			return;
		}
		if(npwd==null||npwd.length()==0){
			response.getWriter().write("新密码不能为空");
			return;
		}
		if(cpwd==null||cpwd.length()==0){
			response.getWriter().write("确认密码不能为空");
			return;
		}
		
		// 两次密码一致验证
		if(!npwd.equals(cpwd)){
			response.getWriter().write("两次密码应该一致");
			return;
		}
		
		UserService service=UserService.getInstance();
		
		// 原始密码是否正确验证
		// 从Session中获取用户对象-获取用户名
		HttpSession session=request.getSession();
		Object obj=session.getAttribute("user");
		String username="";
		if(obj!=null){
			username=((User)obj).getUsername();
			if(service.login(username, upwd)==null){
				response.getWriter().write("原始密码错误");
				return;
			}
		}else{
			response.getWriter().write("登录状态异常！");
			return;
		}

		// 4. 调用Service方法更新密码
		boolean flag=service.changePwd(username, npwd);
		// 5. 根据结果返回提示信息
		String msg=flag==true?"yes":"密码更新失败";
		response.getWriter().write(msg);
	}

}



