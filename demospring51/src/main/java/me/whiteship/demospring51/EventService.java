package me.whiteship.demospring51;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @NonNull
    public String createEvent(@NonNull String name){
        return null;    //'null' is returned by the method declared as @NonNull
                        //'null'은 @NonNull로 선언 된 메서드에서 반환됩니다.
    }
}