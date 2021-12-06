package com.sunbeam;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "books")
public class Book {
	@Id 
	@Column(name = "id")
	public int getBookId() {
		return bookId;
	}
	@Column(name = "name")
	public String getTitle() {
		return title;
	}
	@Column // (name = "author") // -- optional if field name = column name
	public String getAuthor() {
		return author;
	}
	// @Column(name = "subject") // -- optional if field name = column name 
	public String getSubject() {
		return subject;
	}
	// @Column(name = "price") // -- optional if field name = column name
	public double getPrice() {
		return price;
	}
	
	@Transient
	public double getFinalCost() {
		return finalCost;
	}

	private int bookId;
	private String title;
	private String author;
	private String subject;
	private double price;
	private double finalCost;	// price + 5% tax
	
	public Book() {
	}
	public Book(int bookId, String title, String author, String subject, double price) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.subject = subject;
		this.price = price;
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
		this.finalCost = this.price + this.price * 0.05;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", subject=" + subject
				+ ", price=" + price + "]";
	}
}
