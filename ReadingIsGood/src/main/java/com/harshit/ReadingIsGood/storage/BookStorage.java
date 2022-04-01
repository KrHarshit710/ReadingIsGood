package com.harshit.ReadingIsGood.storage;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.harshit.ReadingIsGood.entity.Book;

@Component
public class BookStorage {
	
	Map<Integer,Book> books;
	
	public BookStorage() {
		super();
		this.books = new HashMap<>();
	}

	public void addNewBook(int id, Book book)
	{
		System.out.println(books);
		books.put(id, book);
	}
	
	public void addStock(int id, int copies)
	{
		Book book = books.get(id);
		int currentStock = book.getStock();
		book.setStock(currentStock + copies);
		
		books.put(id, book);
	}
	
	public void removeStock(int id,int copies)
	{
		Book book = books.get(id);
		int currentStock = book.getStock();
		book.setStock(currentStock - copies);
		
		books.put(id, book);
	}
	
	public int getStock(int id)
	{
		return books.get(id).getStock();
	}

}
