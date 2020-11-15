package me.whiteship.demobootweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    /*
    //PersonFormatter를 직접 빈으로 등록(@Component)하게 되면, 아래 설정은 필요 없다
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new PersonFormatter());
    }
    */

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new GreetingInterceptor()).order(0);
        registry.addInterceptor(new AnotherInterceptor())
                .addPathPatterns("/hi")     //지정된 패턴(맵핑)에만 적용됨
                .order(-1);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("mobile/**")    //어떠한 패턴의 요청만 처리할지, 패턴 지정
                .addResourceLocations("classpath:/mobile/");    //Static 리소스를 어디서 찾아야 하는지 위치 지정

    }
}
