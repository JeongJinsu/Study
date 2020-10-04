package me.whiteship.springapplicationcontext;

import me.whiteship.springapplicationcontext.repository.BookRepository;
import me.whiteship.springapplicationcontext.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/*
    3. 빈 설정파일을 xml 이 아니라 자바로 만들수 없을까? 자바설정파일 방법 등장
*/
/*

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
*/

/*
    4. 자바설정파일 방법은 빈을 하나하나 등록해야 하는 번거로움 존재.
    @ComponentScan(basePackageClasses = DemoApplication.class)
    DemoApplication.class 가 위치한 곳부터 컴포넌트 스캐닝.
    스프링은 특정 @애노테이션이(@Service, @Repository..) 붙어있는 클래스를 찾아 빈으로 자동 등록함
*/
@Configuration
@ComponentScan(basePackageClasses = DemoApplication.class)
public class ApplicationConfig {

}