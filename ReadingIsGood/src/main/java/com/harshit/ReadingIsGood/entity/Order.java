package com.harshit.ReadingIsGood.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
public class Order {
	
	private int id;
	
	private int customerId;
	
	private int bookId;
	
	private int copies;
	
	private LocalDateTime localTime;

	public Order(int id, int customerId, int bookId, int copies, LocalDateTime localTime) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.bookId = bookId;
		this.copies = copies;
		this.localTime = localTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}

	public LocalDateTime getLocalTime() {
		return localTime;
	}

	public void setLocalTime(LocalDateTime localTime) {
		this.localTime = localTime;
	}

	

	
	
	

}
