package me.whiteship.demospring51;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AnotherEventHandler {

    @EventListener
    @Order(Ordered.HIGHEST_PRECEDENCE + 2)
    public void handle(MyEvent myEvent) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("Another " + myEvent.getData());
    }

    //스프링부트가 제공하는 이벤트, ApplicationContext 객체 생성되거나, 리플래시 했을때 발생
    @EventListener
    @Async //비동기적으로 이벤트 처리
    public void handle(ContextRefreshedEvent myEvent) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("ContextRefreshedEvent");
    }

    //스프링부트가 제공하는 이벤트, ApplicationContext 객체 싱글톤 소멸 했을때 발생
    @EventListener
    @Async //비동기적으로 이벤트 처리
    public void handle(ContextClosedEvent myEvent) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("ContextClosedEvent");
    }
}
