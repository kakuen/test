package jp.co.fitec.lesson.kaku.bookstore.entity;

import java.util.Date;

public class Book {
	private String isbn;
	private String title;
	private Double price;
	private String publisherCode;
	private Date releaseDate;

	public Book(String isbn,String title,Double price, String publisherCode,Date releaseDate){
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.publisherCode = publisherCode;
		this.releaseDate = releaseDate;		
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public Double getPrice() {
		return price;
	}

	public String getPublisherCode() {
		return publisherCode;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", price=" + price
				+ ", publisherCode=" + publisherCode + ", releaseDate="
				+ releaseDate + "]";
	}
	
	
}
