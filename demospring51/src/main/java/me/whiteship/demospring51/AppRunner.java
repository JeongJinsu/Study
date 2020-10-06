package me.whiteship.demospring51;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    ApplicationContext ctx;

    @Autowired
    BookRepository bookRepository;

    @Value("${app.name}") //스프링부트 에서 제공하는 프로퍼티 불러오는 방법
    String appName;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Environment environment = ctx.getEnvironment();
        System.out.println(environment.getProperty("app.name")); //설정-Edit-JVM으로 설정한 프로퍼티: -Dapp.name="spring" 를 불러오는 방법
        System.out.println(environment.getProperty("app.about")); //.properties 확장 설정파일을 통해 설정한 프로퍼티 를 불러오는 방법

        System.out.println(appName); //스프링부트 에서 제공하는 프로퍼티 불러오는 방법
    }
}
