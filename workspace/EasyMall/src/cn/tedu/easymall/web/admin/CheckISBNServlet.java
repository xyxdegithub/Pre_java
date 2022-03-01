package cn.tedu.easymall.web.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.easymall.service.BookService;

@WebServlet("/admin/checkISBN")
public class CheckISBNServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 接受请求参数
		String isbn=request.getParameter("isbn");
		// 表单验证
		if(isbn==null||isbn.length()==0){
			response.getWriter().write("error");
			return;
		}
		if(isbn.length()!=10&&isbn.length()!=13){
			response.getWriter().write("error");
			return;
		}
		// 调用Service进行验证
		boolean flag=BookService.getInstance().checkISBN(isbn);
		// 根据结果生成提示信息
		String msg=flag?"yes":"no";
		response.getWriter().write(msg);
	}
}



