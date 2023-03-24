package com.wissen.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wissen.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	Optional<Book> findByName(String name);

}
