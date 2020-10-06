package me.whiteship.demospring51;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test") //프로파일 이름 입력 //적용은 Edit Configurations - Active Profiles에 적용 원하는 프로파일명 입력
public class TestConfiguration {

    @Bean
    public BookRepository bookRepository(){
        return new TestBookRepository();
    }

}
