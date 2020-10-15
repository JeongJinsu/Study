package me.whiteship.demospring51;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    EventService eventService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        eventService.createEvent(null); //Passing 'null' argument to parameter annotated as @NotNull
                                              //@NotNull로 주석이 달린 매개 변수에 'null'인수 전달

    }
}
