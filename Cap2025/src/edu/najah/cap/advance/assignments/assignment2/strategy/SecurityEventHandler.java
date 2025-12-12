package edu.najah.cap.advance.assignments.assignment2.strategy;

import edu.najah.cap.advance.assignments.assignment2.Event;

public class SecurityEventHandler implements EventHandlerStrategy {
    @Override
    public void handle(Event e) {
        System.out.println("[SECURITY] handled " + e.getId());
        System.out.println("[SecurityMonitor] alert for " + e.getId());
    }
}
