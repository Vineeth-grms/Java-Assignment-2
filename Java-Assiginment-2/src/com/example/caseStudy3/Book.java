package com.example.caseStudy3;

public class Book {
	private int bookId;
	private String title;
	private String author;
	private boolean avalable;

	public Book(int bookId, String title, String author, boolean avalable) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.avalable = avalable;
	}
//
//	public Book() {
//		
//	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
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

	public boolean Avalable() {
		return avalable;
	}

	public void setAvalable(boolean avalable) {
		this.avalable = avalable;
	}

}
