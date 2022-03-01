package cn.tedu.easymall.web.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.tedu.easymall.entity.Book;
import cn.tedu.easymall.service.BookService;

@WebServlet("/admin/addBook")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 创建FileItem的工厂
		DiskFileItemFactory factory=new DiskFileItemFactory();
		// 创建整体配置类
		ServletFileUpload fileUpload=new ServletFileUpload(factory);
		// 判断是否是文件上传表单
		if(!ServletFileUpload.isMultipartContent(request)){
			throw new RuntimeException("不是文件上传表单");
		}
		// 解决上传的文件名的乱码问题
		fileUpload.setHeaderEncoding("utf-8");
		
		// 解析表单
		try {
			List<FileItem> list=fileUpload.parseRequest(request);
			List<FileItem> textList=new LinkedList<FileItem>();
			List<FileItem> uploadList=new LinkedList<FileItem>();
			// 区分普通表单项和文件上传项
			for(FileItem item:list){
				if(item.isFormField()){// 普通表单项
					textList.add(item);
				}else{// 文件上传项
					uploadList.add(item);
				}
			}
			// 处理普通表单项
			Map<String, String> paramMap=new HashMap<String, String>(textList.size());
			for(FileItem item:textList){
				String name=item.getFieldName();// 属性名
				String value=item.getString("utf-8");// 属性值
				paramMap.put(name, value);
			}
			// 封装数据
			Book book=createBook(paramMap);
			// 将图书信息添加到数据库
			// 先检查ISBN不存在
			boolean hasISBN=BookService.getInstance().checkISBN(book.getIsbn());
			if(hasISBN){
				throw new RuntimeException("添加异常：ISBN已经存在");
			}
			boolean flag=BookService.getInstance().addBook(book);
			if(!flag){
				response.getWriter().write("no");
				return;
			}
			// 处理文件上传项
			String dirPath="/user/img/goods/"+book.getIsbn();
			// 获取指定目录在服务器上的绝对路径
			String realDirPath=getServletContext().getRealPath(dirPath);
			// 工作空间的绝对路径
			String realDirPath2="D:\\javawork\\EasyMall\\WebContent\\user\\img\\goods\\"+book.getIsbn();
			// 创建文件夹
			new File(realDirPath).mkdirs();
			new File(realDirPath2).mkdirs();
			
			for(FileItem item:uploadList){
				String fileName=item.getName(); // 获取文件名称
				if(fileName==null||fileName.length()==0){// 未上传文件
					continue;
				}
				InputStream is=item.getInputStream(); // 获取文件数据输入流
				// 声明文件的输出流对象
				FileOutputStream fos=
						new FileOutputStream(realDirPath+"/"+fileName);
				FileOutputStream fos2=
						new FileOutputStream(realDirPath2+"/"+fileName);
				byte[] arr=new byte[1024*10];//10kb
				int len=is.read(arr);
				while(len!=-1){
					fos.write(arr, 0, len);
					fos2.write(arr, 0, len);
					len=is.read(arr);
				}
				// 关流
				is.close();
				fos.close();
				fos2.close();
			}
			response.getWriter().write("yes");
		} catch (FileUploadException e) {
			e.printStackTrace();
			response.getWriter().write("no");
		}
	}
	
	public Book createBook(Map<String, String> map){
		Book book=new Book();
		book.setIsbn(map.get("isbn"));
		book.setTitle(map.get("title"));
		book.setAuthor(map.get("author"));
		book.setPackaging(map.get("packaging"));
		book.setFormat(map.get("format"));
		book.setForm(map.get("form"));
		book.setPress(map.get("press"));
		
		if(map.get("price").length()==0){
			book.setPrice(0d);
		}else{
			book.setPrice(Double.parseDouble(map.get("price")));
		}
		
		if(map.get("edition").length()==0){
			book.setEdition(0);
		}else{
			book.setEdition(Integer.parseInt(map.get("edition")));
		}
		
		if(map.get("pages").length()==0){
			book.setPages(0);
		}else{
			book.setPages(Integer.parseInt(map.get("pages")));
		}
		
		if(map.get("words").length()==0){
			book.setWords(0);
		}else{
			book.setWords(Integer.parseInt(map.get("words")));
		}
		
		try {
			book.setPublished(DateFormat.getDateInstance().parse(map.get("published")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return book;
	}

}
