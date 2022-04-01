package com.harshit.ReadingIsGood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.harshit.ReadingIsGood.entity.Book;
import com.harshit.ReadingIsGood.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	
	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}

	@PostMapping("/add")
	public void addBook(@RequestBody Book book)
	{
		bookService.addBook(book);
	}
	
	@PatchMapping("/updateStock")
	public void addStock(@RequestBody Book book)
	{
		
	}

}
