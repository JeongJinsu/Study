package me.whiteship.springapplicationcontext;

import me.whiteship.springapplicationcontext.repository.BookRepository;
import me.whiteship.springapplicationcontext.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
    3. 빈 설정파일을 xml 이 아니라 자바로 만들수 없을까? 자바설정파일 방법 등장
*/

@Configuration
public class ApplicationConfig {

    @Bean
    public BookRepository bookRepository() {
        return new BookRepository();
    }

    @Bean
    public BookService bookService() {
        BookService service = new BookService();
        service.setBookRepository(bookRepository());
        return service;
    }
}
