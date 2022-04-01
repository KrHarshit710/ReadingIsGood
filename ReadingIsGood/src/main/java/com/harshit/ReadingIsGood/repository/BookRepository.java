package com.harshit.ReadingIsGood.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.harshit.ReadingIsGood.entity.Book;
import com.harshit.ReadingIsGood.storage.BookStorage;

@Repository
public class BookRepository {
	
	@Autowired
	private BookStorage bookStorage;

	public BookRepository(BookStorage bookStorage) {
		super();
		this.bookStorage = bookStorage;
	}

	public void addBook(Book book)
	{
		int id = book.getId();
		bookStorage.addNewBook(id, book);
	}
	
	

}
