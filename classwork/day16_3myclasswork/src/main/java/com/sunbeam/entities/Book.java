package com.sunbeam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
	@Id 
	@Column(name = "id")
	private int bookId;
	@Column(name = "name")
	private String title;
	@Column
	private String author;
	// @Column(name = "subject") 
	private String subject;
	// @Column(name = "price")
	private double price;
	
	public Book() {
	}
	public Book(int bookId, String title, String author, String subject, double price) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.subject = subject;
		this.price = price;
	}
	
	public Book(int bookId, String title, String author) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
	}
	public int getBookId() {
		return bookId;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getSubject() {
		return subject;
	}
	public double getPrice() {
		return price;
	}	

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", subject=" + subject
				+ ", price=" + price + "]";
	}
}
