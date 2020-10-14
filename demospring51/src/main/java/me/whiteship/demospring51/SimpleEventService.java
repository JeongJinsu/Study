package me.whiteship.demospring51;

import org.springframework.stereotype.Service;

@Service
public class SimpleEventService implements EventService {

    @Override
    public void createEvent() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("CreateEvent()");
    }

    @Override
    public void publishEvent() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("PublishEvent()");
    }

    @Override
    public void deleteEvent() {
        System.out.println("DeleteEvent()");
    }
}
