package me.whiteship.springapplicationcontext.service;

import me.whiteship.springapplicationcontext.repository.BookRepository;

public class BookService {

    public BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

}
