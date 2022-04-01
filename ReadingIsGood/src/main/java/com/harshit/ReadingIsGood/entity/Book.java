package com.harshit.ReadingIsGood.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String title;
	
	private double price;
	
	private int stock;

	public Book(int id, String title, double price, int stock) {
		super();
		this.id = id;
		this.title = title;
		this.stock = stock;
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", price=" + price + ", stock=" + stock + "]";
	}
	
	

}
