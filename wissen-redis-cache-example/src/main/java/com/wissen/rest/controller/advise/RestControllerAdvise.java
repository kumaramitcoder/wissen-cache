package com.wissen.rest.controller.advise;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.wissen.exception.BookNotFoundException;

@RestControllerAdvice
public class RestControllerAdvise {

	@ExceptionHandler(BookNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String bookNotFoundException(BookNotFoundException be) {
		return be.getMessage();
	}
}
