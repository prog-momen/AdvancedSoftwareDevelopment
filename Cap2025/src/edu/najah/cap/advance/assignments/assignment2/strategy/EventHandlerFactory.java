package edu.najah.cap.advance.assignments.assignment2.strategy;

public class EventHandlerFactory {

    public EventHandlerStrategy get(String type) {
        if ("SECURITY".equals(type)) return new SecurityEventHandler();
        if ("SYSTEM".equals(type)) return new SystemEventHandler();
        return new UserEventHandler();
    }
}
