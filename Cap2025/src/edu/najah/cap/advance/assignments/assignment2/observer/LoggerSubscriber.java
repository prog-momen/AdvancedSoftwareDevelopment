package edu.najah.cap.advance.assignments.assignment2.observer;

import edu.najah.cap.advance.assignments.assignment2.Logger;

public class LoggerSubscriber implements EventSubscriber {
    private final Logger logger;

    public LoggerSubscriber(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void onEvent(EventNotification n) {
        logger.log(n.getEvent());
    }
}
