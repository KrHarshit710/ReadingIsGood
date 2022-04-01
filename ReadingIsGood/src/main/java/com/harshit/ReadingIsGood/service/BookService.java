package com.harshit.ReadingIsGood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshit.ReadingIsGood.entity.Book;
import com.harshit.ReadingIsGood.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	public void addBook(Book book)
	{
		bookRepository.addBook(book);
	}

}
