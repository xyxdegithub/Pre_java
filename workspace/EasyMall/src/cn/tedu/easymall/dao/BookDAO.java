package cn.tedu.easymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import cn.tedu.easymall.entity.Book;
import cn.tedu.easymall.util.DBUtil2;

public class BookDAO {
	
	// 单例模式
	private BookDAO(){}
	private static BookDAO instance=new BookDAO();
	public static BookDAO getInstance(){
		return instance;
	}
	
	public Book getBookByISBN(String isbn){
		String sql="select * from t_book where isbn=?";
		
		try(Connection conn=DBUtil2.getConn();
				PreparedStatement ps=conn.prepareStatement(sql)){
			ps.setString(1, isbn);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){ //也可以用apache dbutils实现自动生成
				String title=rs.getString("title");
				String author=rs.getString("author");
				Double price=rs.getDouble("price");
				String press=rs.getString("press");
				Integer edition=rs.getInt("edition");
				Date published=rs.getDate("published");
				Integer pages=rs.getInt("pages");
				Integer words=rs.getInt("words");
				String packaging=rs.getString("packaging");
				String format=rs.getString("format");
				String form=rs.getString("form");
				Book book=new Book(isbn, title, author, price, press, edition, published, pages, words, packaging, format, form);
				return book;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	
	
	public List<Book> listAllBooks(){
		List<Book> list=new LinkedList<>();
		String sql="select isbn, title, price, press "
				+ "from t_book";
		
		try(Connection conn=DBUtil2.getConn();
				PreparedStatement ps=conn.prepareStatement(sql)){
			ResultSet rs=ps.executeQuery(); // 执行查询
			while(rs.next()){
				String isbn=rs.getString("isbn");
				String title=rs.getString("title");
				Double price=rs.getDouble("price");
				String press=rs.getString("press");
				Book book=new Book(isbn, title, price, press);
				list.add(book);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
				
		return list;		
	}

	public boolean getBookByISBN2(String isbn) {
		String sql="select * from t_book where isbn=?";
		try(Connection conn=DBUtil2.getConn();
				PreparedStatement ps=conn.prepareStatement(sql)){
			ps.setString(1, isbn);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){// ISBN已存在
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public boolean insertBook(Book book) {
		String sql="insert into t_book values(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try(Connection conn=DBUtil2.getConn();
				PreparedStatement ps=conn.prepareStatement(sql)){
			ps.setString(1, book.getIsbn());
			ps.setString(2, book.getTitle());
			ps.setString(3, book.getAuthor());
			ps.setDouble(4, book.getPrice());
			ps.setString(5, book.getPress());
			ps.setInt(6, book.getEdition());
			ps.setDate(7, new java.sql.Date(book.getPublished().getTime()));
			ps.setInt(8, book.getPages());
			ps.setInt(9, book.getWords());
			ps.setString(10, book.getPackaging());
			ps.setString(11, book.getFormat());
			ps.setString(12, book.getForm());
			int row=ps.executeUpdate();
			if(row==1){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
