package com.librarymanagement.dto;

public class Book {
	
	private int bookid;
	private String name;
	private String author;
	private String category;
	private String year;
	
	public String getPublishedYear() {
		return year;
	}
	public void setPublishedYear(String year) {
		this.year = year;
	}
	public String getBookName() {
		return name;
	}
	public void setBookName(String name) {
		this.name = name;
	}
	public String getAuthorName() {
		return author;
	}
	public void setAuthorName(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getBookId() {
		return bookid;
	}
	public void setBookId(int bookid) {
		this.bookid = bookid;
	}

}
