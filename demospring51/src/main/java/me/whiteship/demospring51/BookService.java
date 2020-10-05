package me.whiteship.demospring51;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

public class BookService {
    // 1. BookRepository에 해당되는 빈 하나만 주입받을때
    @Autowired @Qualifier("myBookRepository")
    BookRepository bookRepository;

    public void printBookRepository(){
        System.out.println(bookRepository.getClass());
    }

    /*
    // 2. BookRepository에 해당되는 빈 모두를 주입 받고 싶을때
    @Autowired
    List<BookRepository> bookRepositories;

    public void printBookRepository() {
        this.bookRepositories.forEach(System.out::println);
    }
    */
}
