package me.whiteship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//핸들러 맵핑 두가지 중
//1. RequestMappingHandlerMapping 을 사용한다
@Controller
public class HelloController {

    @Autowired
    HelloService helloService;

    //1) MV(모델&뷰)가 널 인경우: @ResponseBody때문에 뷰리졸버를 타지 않는다
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello, " + helloService.getName();
    }

    //2) MV(모델&뷰)가 널이 아닌경우: 뷰리졸버를 탄다
   @GetMapping("/sample")
    public String sample(){
        //return "/WEB-INF/sample.jsp";
       return "sample"; // WebConfig에서 뷰리졸버 커스텀했기에 이렇게 줄여서 쓸 수 있다
    }
}
