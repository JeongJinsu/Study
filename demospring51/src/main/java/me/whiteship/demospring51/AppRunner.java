package me.whiteship.demospring51;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    MessageSource messageSource;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(messageSource.getMessage("greeting", new String[]{"keesun1"}, Locale.KOREA));
        System.out.println(messageSource.getMessage("greeting", new String[]{"keesun2"}, Locale.getDefault())); //운영체제가 한글이라 _ko_KR.properties 적용됨
    }
}
