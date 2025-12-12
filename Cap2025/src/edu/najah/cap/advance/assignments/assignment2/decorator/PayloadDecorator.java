package edu.najah.cap.advance.assignments.assignment2.decorator;

public abstract class PayloadDecorator implements EventPayload {
    protected final EventPayload wrappee;

    protected PayloadDecorator(EventPayload wrappee) {
        this.wrappee = wrappee;
    }
}
