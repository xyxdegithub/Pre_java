package cn.tedu.easymall.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.tedu.easymall.entity.Book;
import cn.tedu.easymall.service.BookService;

@WebServlet("/listAllBooks")
public class ListBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 调用service获取图书数据
		List<Book> books=BookService.getInstance().findAllBooks();
		
		// 将list集合的数据变成JSON格式字符串
		String jsonStr=JSON.toJSONString(books);
		
		// 通知浏览器本次返回数据格式为JSON
		response.setContentType("application/json;charset=utf-8");
		
		// 将json字符串发送给浏览器
		response.getWriter().write(jsonStr);
	}
}



