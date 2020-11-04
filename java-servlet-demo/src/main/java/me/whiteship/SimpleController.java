package me.whiteship;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//핸들러 맵핑 두가지 중
//2. BeanNameUrlHandlerMapping 을 사용한다
@org.springframework.stereotype.Controller("/simple")
public class SimpleController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //return new ModelAndView("/WEB-INF/simple.jsp");
        return new ModelAndView("simple");  // WebConfig에서 뷰리졸버 커스텀했기에 이렇게 줄여서 쓸 수 있다
    }

}
