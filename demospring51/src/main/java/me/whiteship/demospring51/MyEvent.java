package me.whiteship.demospring51;

import org.springframework.context.ApplicationEvent;

//스프링 4.2버전 이전에는 ApplicationEvent를 반드시 상속받아서 이벤트 객체를 구현했어야 했다
//이후엔 extends ApplicationEvent  받지 않아도 된다.

//원하는 데이터를 이벤트 담아서 핸들러로 전송 하고, 핸들러는 받은 이벤트를 처리할 수 있다
//이벤트 작성 클래스
public class MyEvent extends ApplicationEvent {

    private int data;
    private Object source;

    public MyEvent(Object source) {
        super(source);
    }

    public MyEvent(Object source, int data) {
        super(source);
        this.data = data;
        this.source = source;
    }

    public int getData() {
        return data;
    }

    @Override
    public Object getSource() {
        return source;
    }
}
