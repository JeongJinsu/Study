package me.whiteship.demobootweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
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

    @Bean
    public Jaxb2Marshaller jaxb2Marshaller(){
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setPackagesToScan(Person.class.getPackageName());   // 도메인 객체가 들어있는 패키지 이름을 인자로 주어야 한다
        return jaxb2Marshaller;                                             // 도메인 객체가 .setPackagesToScan 에 의해 스캔 될수 있도록
    }                                                                       // @XmlRootElement를 도메인 클래스에 달아줘야 한다

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
