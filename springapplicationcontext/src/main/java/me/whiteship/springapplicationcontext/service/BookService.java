package me.whiteship.springapplicationcontext.service;

import me.whiteship.springapplicationcontext.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class BookService {

    public BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

}
