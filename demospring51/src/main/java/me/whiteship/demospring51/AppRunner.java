package me.whiteship.demospring51;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Arrays;

@Component
public class AppRunner implements ApplicationRunner {

    @Qualifier("defaultValidator")
    @Autowired
    Validator validator;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(validator.getClass()); //LocalValidatorFactoryBean 주입된것 확인

        Event event = new Event();
        event.setLimit(-1);         //0 이상이어야 합니다
        event.setEmail("12345");    //올바른 형식의 이메일 주소여야 합니다

        //BeanPropertyBindingResult는 객체에 대한 에러 정보를 담는 객체이며 Errors의 구현체다.
        //event 객체에 에러가 있을 경우 이 객체에 정보가 담기게 되며 errors를 통해 에러 정보를 구할 수 있다.
        Errors errors = new BeanPropertyBindingResult(event, "event");

        validator.validate(event, errors);

        System.out.println(errors.hasErrors());

        errors.getAllErrors().forEach(e -> {
            System.out.println("------error code------");
            Arrays.stream(e.getCodes()).forEach(System.out::println);
            System.out.println(e.getDefaultMessage());
        });
    }
}
