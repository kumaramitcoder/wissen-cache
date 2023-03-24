package com.wissen.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wissen.accelerators.cache.service.WissenCache;
import com.wissen.entity.Book;
import com.wissen.exception.BookNotFoundException;
import com.wissen.repository.BookRepository;
import com.wissen.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	WissenCache wissenCache;

	private static final String CACHE_NAME = "books";
	
	@Override
	public Book createBook(Book book) {
		// save to database
		book = bookRepository.save(book);
		// save to cache
		wissenCache.addOrUpdate(Long.toString(book.getId()), book);

		return book;
	}

	@Override
	public Book getBook(long id) {
		Book book = wissenCache.get(CACHE_NAME, Long.toString(id));
		if (book == null) {
			book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
			wissenCache.addOrUpdate(CACHE_NAME, Long.toString(id), book);
		}

		return book;
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> books = wissenCache.get(CACHE_NAME, "booksList");
		if (books == null || books.isEmpty()) {
			books = bookRepository.findAll().stream().collect(Collectors.toList());
			wissenCache.addOrUpdate(CACHE_NAME, "booksList", books);
		}

		return books;
	}
	
	@Override
	public void removeBook(long id) {
		wissenCache.remove(CACHE_NAME, Long.toString(id));
		bookRepository.deleteById(id);
	}

	@Override
	public void removeAllBooks() {
		wissenCache.removeAll(CACHE_NAME);
		bookRepository.deleteAll();
	}
}
