package com.wissen.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wissen.entity.Book;
import com.wissen.service.BookService;

@RestController
public class BookRestController {

	@Autowired
	BookService bookService;

	@PostMapping("/book")
	public ResponseEntity<Book> createBook(@RequestBody Book book) {
		book = bookService.createBook(book);

		return ResponseEntity.ok(book);
	}

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> books = bookService.getAllBooks();

		return ResponseEntity.ok(books);
	}

	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getBook(@PathVariable long id) {
		Book book = bookService.getBook(id);

		return ResponseEntity.ok(book);
	}

	@DeleteMapping("/book/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable long id) {
		bookService.removeBook(id);

		return ResponseEntity.ok(String.format("Book with id %s is Successfully deleted", id));
	}

	@DeleteMapping("/books")
	public ResponseEntity<String> deleteAllBooks() {
		bookService.removeAllBooks();

		return ResponseEntity.ok("All books are cleared from DB & Cache server");
	}
}
