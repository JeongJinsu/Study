package me.whiteship.demospring51;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component ////WebConfig 없이 빈으로 등록해서 사용할 수도 있다
public class EventFormatter implements Formatter<Event> {

    @Override
    public Event parse(String s, Locale locale) throws ParseException {
        return new Event(Integer.parseInt(s));
    }

    @Override
    public String print(Event event, Locale locale) {
        return event.getId().toString();
    }
}
