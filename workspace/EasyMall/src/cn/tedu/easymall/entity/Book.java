package cn.tedu.easymall.entity;

import java.util.Date;

public class Book {
	
	private String isbn;
	private String title;
	private String author;
	private Double price;
	private String press; // 出版社
	private Integer edition; // 版次
	private Date published; // 出版日期/时间
	private Integer pages;
	private Integer words;
	private String packaging; // 包装
	private String format; // 开本
	private String form; // 用纸
	
	public Book() {
	}

	public Book(String isbn, String title, Double price, String press) {
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.press = press;
	}

	public Book(String isbn, String title, String author, Double price,
			String press, Integer edition, Date published, Integer pages,
			Integer words, String packaging, String format, String form) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
		this.press = press;
		this.edition = edition;
		this.published = published;
		this.pages = pages;
		this.words = words;
		this.packaging = packaging;
		this.format = format;
		this.form = form;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public Integer getEdition() {
		return edition;
	}

	public void setEdition(Integer edition) {
		this.edition = edition;
	}

	public Date getPublished() {
		return published;
	}

	public void setPublished(Date published) {
		this.published = published;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Integer getWords() {
		return words;
	}

	public void setWords(Integer words) {
		this.words = words;
	}

	public String getPackaging() {
		return packaging;
	}

	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author
				+ ", price=" + price + ", press=" + press + ", edition="
				+ edition + ", published=" + published + ", pages=" + pages
				+ ", words=" + words + ", packaging=" + packaging + ", format="
				+ format + ", form=" + form + "]";
	}

}
