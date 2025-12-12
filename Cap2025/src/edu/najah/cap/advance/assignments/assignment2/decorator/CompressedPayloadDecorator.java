package edu.najah.cap.advance.assignments.assignment2.decorator;

public class CompressedPayloadDecorator extends PayloadDecorator {

    public CompressedPayloadDecorator(EventPayload wrappee) {
        super(wrappee);
    }

    @Override
    public String render() {
        return "CMP(" + wrappee.render() + ")";
    }
}
