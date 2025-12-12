package edu.najah.cap.advance.assignments.assignment2.strategy;

import edu.najah.cap.advance.assignments.assignment2.Event;

public class UserEventHandler implements EventHandlerStrategy {
    @Override
    public void handle(Event e) {
        System.out.println("[USER] user-specific step for " + e.getId());
    }
}
