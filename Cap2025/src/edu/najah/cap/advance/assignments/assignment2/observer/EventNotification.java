package edu.najah.cap.advance.assignments.assignment2.observer;

import edu.najah.cap.advance.assignments.assignment2.Event;

public class EventNotification {
    private final Event event;

    public EventNotification(Event event) {
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }
}
