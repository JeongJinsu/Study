package me.whiteship.demospring51;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync //@Async 비동기적 이벤트 순서로 하고 싶을때 실행 클래스에 붙여야 함
public class Demospring51Application {

    public static void main(String[] args) {
        SpringApplication.run(Demospring51Application.class, args);
    }

}
