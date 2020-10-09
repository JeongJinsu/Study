package me.whiteship.demospring51;

import java.beans.PropertyEditorSupport;

public class EventEditor extends PropertyEditorSupport {

    /*
     *getAsText는 PropertyEditor가 받은 객체를 getValue 메서드를 통해 가져오고
     *이 Event 객체를 문자열 정보로 변환해서 반환하는 역할을 한다.
     */
    @Override
    public String getAsText() {
        Event value = (Event) getValue(); //Value는 PropertyEditor가 가지고 있는 값 (이 예제에선 프로퍼티인 Event객체를 지칭)
        return value.getId().toString();
    }

    /*
     *setAsText는 사용자가 입력한 데이터를 Event 객체로 변환해 주는 역할을 한다.
     *만일 /event/1 이라는 요청이 있을시 1이라는 데이터를 Event로 변환할 때
     *setAsText의 메서드가 호출되어 사용자 데이터를 변환한다.
     */
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(new Event(Integer.parseInt(text)));
    }

    //조심해야할 것은 EventEditor의 getValue와 setValue 메서드는 thread-safe하지 않다.
    //따라서 절대 스프링 빈으로 등록해서 쓰면 안된다.

}
