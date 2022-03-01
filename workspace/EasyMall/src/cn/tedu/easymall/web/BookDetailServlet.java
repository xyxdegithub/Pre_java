package cn.tedu.easymall.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.tedu.easymall.entity.Book;
import cn.tedu.easymall.service.BookService;

@WebServlet("/bookDetail")
public class BookDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 接受请求参数
		String isbn=request.getParameter("isbn");
		// 调用service方法
		Book book=BookService.getInstance().findBookByISBN(isbn);
		if(book==null){// 未找到该图书
			response.getWriter().write("error");
		}else{
			// 将图书数据转变成json字符串
			String jsonStr = JSON.toJSONString(book);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(jsonStr);
		}
	}

}
