package me.whiteship.demospring51;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    ApplicationContext resourceLoader;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(resourceLoader.getClass()); //AnnotationConfigServletWebServerApplicationContext

        Resource resource = resourceLoader.getResource("classpath:/text.txt"); //classpath: 기준으로 리소스를 찾는다
        System.out.println(resource.getClass()); //ClassPathResource

        resource = resourceLoader.getResource("text.txt"); //웹 어플리케이션 루트(context path '') 상대경로 기준으로 리소스를 찾는다
        System.out.println(resource.getClass()); //ServletContextResource

        System.out.println(resource.exists());
        System.out.println(resource.getDescription());
        System.out.println(Files.readString(Path.of(resource.getURI()))); //자바 11에서 추가된 ReadString 메소드

    }
}
