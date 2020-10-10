package me.whiteship.demospring51;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

public class EventConverter {

    @Component //WebConfig 없이 빈으로 등록해서 사용할 수도 있다
    public static class StringToEventConverter implements Converter<String, Event> {
        @Override
        public Event convert(String s) {
            return new Event(Integer.parseInt(s));
        }
    }

    @Component ////WebConfig 없이 빈으로 등록해서 사용할 수도 있다
    public static class EventToStringConverter implements Converter<Event, String> {
        @Override
        public String convert(Event event) {
            return event.getId().toString();
        }
    }


}
