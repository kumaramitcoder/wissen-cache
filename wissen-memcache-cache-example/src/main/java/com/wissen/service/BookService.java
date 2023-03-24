package com.wissen.service;

import java.util.List;

import com.wissen.entity.Book;

public interface BookService {
	List<Book> getAllBooks();

	Book getBook(long id);
	
	Book createBook(Book book);
	
	void removeBook(long id);
	
	void removeAllBooks();
}
