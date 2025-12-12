package edu.najah.cap.advance.assignments.assignment2.observer;

import java.util.ArrayList;
import java.util.List;

public class EventPublisher {
    private final List<EventSubscriber> subscribers = new ArrayList<>();

    public void subscribe(EventSubscriber s) {
        subscribers.add(s);
    }

    public void unsubscribe(EventSubscriber s) {
        subscribers.remove(s);
    }

    public void publish(EventNotification n) {
        for (EventSubscriber s : subscribers) {
            s.onEvent(n);
        }
    }
}
