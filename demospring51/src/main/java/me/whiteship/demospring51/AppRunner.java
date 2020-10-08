package me.whiteship.demospring51;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.util.Arrays;

@Component
public class AppRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Event event = new Event();
        EventValidator eventValidator = new EventValidator();

        //BeanPropertyBindingResult는 객체에 대한 에러 정보를 담는 객체이며 Errors의 구현체다.
        //event 객체에 에러가 있을 경우 이 객체에 정보가 담기게 되며 errors를 통해 에러 정보를 구할 수 있다.
        Errors errors = new BeanPropertyBindingResult(event, "event");

        eventValidator.validate(event, errors);

        System.out.println(errors.hasErrors());

        errors.getAllErrors().forEach(e -> {
            System.out.println("------error code------");
            Arrays.stream(e.getCodes()).forEach(System.out::println);
            System.out.println(e.getDefaultMessage());
        });
    }
}
