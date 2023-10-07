package com.teknopar.exceptionHandling2.service.concretes;

import com.teknopar.exceptionHandling2.model.Book;
import com.teknopar.exceptionHandling2.repository.BookRepository;
import com.teknopar.exceptionHandling2.service.abstracts.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    @Override
    public Book addBook(Book book) {
        if (book.getTitle() == null || book.getAuthor() == null){
            throw new IllegalArgumentException("Kitap başlığı ve yazarı zorunludur.");
        }

        return bookRepository.save(book);
    }
}
