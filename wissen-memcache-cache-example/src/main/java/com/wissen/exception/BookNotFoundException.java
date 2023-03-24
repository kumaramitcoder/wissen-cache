package com.wissen.exception;

public class BookNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8513363060657530956L;

	public BookNotFoundException() {
		super();
	}

	public BookNotFoundException(long id) {
		super("Book not found with id: " + id);
	}

}
