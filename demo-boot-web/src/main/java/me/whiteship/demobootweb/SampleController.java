package me.whiteship.demobootweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    /*
    //url path로 받을때
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        return "hello " + name;
    }
    */

    /*
    //url로 path로 받은 name값을 Person객체로 받을때
    //스프링은 name을 Person객체로 변환하는 방법을 모르기에
    //포매터를 직접 설정해 줘야 한다 (PersonFormatter)
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") Person person){
        return "hello " + person.getName();
    }
    */

    //requestParam으로 받을때 ('스프링 데이터 JPA' 기능 중 '도메인 클래스 컨버터'를 사용)
    @GetMapping("/hello")
    public String hello(@RequestParam("id") Person person){
        return "hello " + person.getName();
    }

}
