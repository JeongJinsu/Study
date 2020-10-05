package me.whiteship.demospring51;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

@SpringBootApplication
public class Demospring51Application {

    public static void main(String[] args) {
        var app = new SpringApplication(Demospring51Application.class);
        //앱 실행 전, 빈을 등록할 경우 (싱글톤으로 인스턴스화 되는 @ComponentScan, @Configuration@Bean 에 비해 성능상의 이점은 있으나, 일일이 등록해야하는 단점)
        app.addInitializers(new ApplicationContextInitializer<GenericApplicationContext>() {
            @Override
            public void initialize(GenericApplicationContext ctx) {
                ctx.registerBean(BookService.class);
            }
        });
        //앱 실행
        app.run(args);
    }

}
