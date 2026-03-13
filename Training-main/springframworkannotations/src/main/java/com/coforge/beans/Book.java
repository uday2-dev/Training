package com.coforge.beans;

import org.springframework.beans.factory.annotation.Value;

public class Book {
	@Value("1234")
	private long bookid;
	@Value("the last of us")
	private String title;
	@Value("600")
	private double price;
	@Value("camelio")
	private String author;

	public long getBookid() {
		return bookid;
	}

	public void setBookid(long bookid) {
		this.bookid = bookid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", title=" + title + ", price=" + price + ", author=" + author + "]";
	}

	public Book(long bookid, String title, double price, String author) {
		super();
		this.bookid = bookid;
		this.title = title;
		this.price = price;
		this.author = author;
	}

	public Book() {
		super();
	}
}