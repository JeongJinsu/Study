package me.whiteship.demospring51;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
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


        /*
         * 스프링 EL의 기반 ExpressionParser
         */
        ExpressionParser parser = new SpelExpressionParser();
        // .parseExpression 리턴값이 Expression 그 자체로 인자값 "#{2 + 100}" 과 동일
        Expression expression = parser.parseExpression("2 + 100");
        // Integer.class 타입으로 값을 가져오겠다 지정.
        // (String -> Integer) 해당하는 타입으로 변환할때
        // 데이터바인딩: ConversionService를 사용해 값을 변환후 가져온다
        Integer value = expression.getValue(Integer.class);

        System.out.println(value);
    }
}
