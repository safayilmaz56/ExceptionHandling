package com.teknopar.exceptionHandling2.controller;

import com.teknopar.exceptionHandling2.model.Book;
import com.teknopar.exceptionHandling2.service.abstracts.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class BookController {

    private BookService bookService;

    @PostMapping("/addBook")
    public ResponseEntity<?> addBook(@RequestBody Book book){
        try {
            Book addedBook = bookService.addBook(book);
            return ResponseEntity.ok(addedBook);
        }catch (IllegalArgumentException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
