package com.teknopar.exceptionHandling2.repository;

import com.teknopar.exceptionHandling2.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
