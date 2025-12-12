package edu.najah.cap.advance.assignments.assignment2.strategy;

import edu.najah.cap.advance.assignments.assignment2.Event;

public class SystemEventHandler implements EventHandlerStrategy {
    @Override
    public void handle(Event e) {
        System.out.println("[SYSTEM] handled " + e.getId());
    }
}
