package me.whiteship.demospring51;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    @Value("#{1 + 1}")      //#표현식을 사용하는 방법
    int value;              //2

    @Value("#{'Hello ' + 'world'}")
    String greeting;        //Hello world

    @Value("#{1 eq 1}")
    boolean trueOrFalse;    //true

    @Value("hello")
    String hello;

    @Value("${my.data}")    //$프로퍼티를 사용하는 방법
    int myValue;

    @Value("#{${my.data} eq 100}")    //#표현식 안에 $프로퍼티를 넣어 사용하는 방법
    boolean isMyValue100;

    @Value("#{sample.data}")
    int sampleDate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("------------------");
        System.out.println(value);
        System.out.println(greeting);
        System.out.println(trueOrFalse);
        System.out.println(hello);
        System.out.println(myValue);
        System.out.println(isMyValue100);
        System.out.println(sampleDate);
    }
}
