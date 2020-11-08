package me.whiteship;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    /*
    //기본 뷰리졸버를 커스텀
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/");    // /WEB-INF/밑에 뷰가 있고
        viewResolver.setSuffix(".jsp");         //  이 뷰는 항상 .jsp로 끝난다. 고 설정
        return viewResolver;
    }
    */

    //@EnableWebMvc에 구현되어있는 빈들(Import된 빈들)이 디스패쳐 서블릿 인터페이스 구현체로 등록되고
    //해당 구현체들의 일부 설정값을 바꾸는 방법으로 간단하게 커스텀 할 수 있다
    //이 방법을 사용하려면, WebMvcConfigurer를 구현해야 한다
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/",".jsp");
    }
}
