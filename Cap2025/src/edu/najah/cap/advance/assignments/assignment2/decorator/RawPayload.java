package edu.najah.cap.advance.assignments.assignment2.decorator;

public class RawPayload implements EventPayload {
    private final String raw;

    public RawPayload(String raw) {
        this.raw = raw;
    }

    @Override
    public String render() {
        return raw;
    }
}
