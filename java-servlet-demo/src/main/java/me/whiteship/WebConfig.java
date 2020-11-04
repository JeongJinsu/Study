package me.whiteship;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan
public class WebConfig {

    //기본 뷰리졸버를 커스텀
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/");    // /WEB-INF/밑에 뷰가 있고
        viewResolver.setSuffix(".jsp");         //  이 뷰는 항상 .jsp로 끝난다. 고 설정
        return viewResolver;
    }
}
