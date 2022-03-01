package cn.tedu.easymall.service;

import java.util.List;

import cn.tedu.easymall.dao.BookDAO;
import cn.tedu.easymall.entity.Book;

public class BookService {
	
	// 单例
	private BookService(){};
	private static BookService instance=new BookService();
	public static BookService getInstance(){
		return instance;
	}
	
	public Book findBookByISBN(String isbn){
		return BookDAO.getInstance().getBookByISBN(isbn);
	}
	
	public List<Book> findAllBooks(){
		return BookDAO.getInstance().listAllBooks();
	}

	public boolean checkISBN(String isbn) {
		return BookDAO.getInstance().getBookByISBN2(isbn);
	}

	public boolean addBook(Book book) {
		return BookDAO.getInstance().insertBook(book);
	}

}
