package edu.najah.cap.advance.assignments.assignment2.decorator;

public class EncryptedPayloadDecorator extends PayloadDecorator {

    public EncryptedPayloadDecorator(EventPayload wrappee) {
        super(wrappee);
    }

    @Override
    public String render() {
        return "ENC(" + wrappee.render() + ")";
    }
}
