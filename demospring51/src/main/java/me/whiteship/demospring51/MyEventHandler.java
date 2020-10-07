package me.whiteship.demospring51;

import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//스프링 4.2버전 이전에는 ApplicationListener<해당 이벤트 타입 제네릭>를 반드시 상속받아서 이벤트 객체를 구현했어야 했다
//이후엔 implements ApplicationListener<MyEvent> 를 구현하지 않아도 된다.

//핸들러는 빈으로 등록해야 한다
@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 1) //핸들러가 여러개일때 우선순위 설정
public class MyEventHandler implements ApplicationListener<MyEvent> {

    @Override //@EventListener (implements ApplicationListener<MyEvent>를 구현하지 않을땐 이 애노테이션을 이벤트 처리하는 메소드에 달아야 한다
    public void onApplicationEvent(MyEvent myEvent) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("이벤트를 받았다. 데이터는 " + myEvent.getData()); //이벤트를 받았다. 데이터는 100
        System.out.println(myEvent.getSource().toString()); //me.whiteship.demospring51.AppRunner@37b52340 //이벤트를 발생시킨 클래스
    }


}
