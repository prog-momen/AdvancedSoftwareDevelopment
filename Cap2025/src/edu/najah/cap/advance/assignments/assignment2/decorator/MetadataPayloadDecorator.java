package edu.najah.cap.advance.assignments.assignment2.decorator;

public class MetadataPayloadDecorator extends PayloadDecorator {
    private final String metadata;

    public MetadataPayloadDecorator(EventPayload wrappee, String metadata) {
        super(wrappee);
        this.metadata = metadata;
    }

    @Override
    public String render() {
        return "META(" + metadata + ")::" + wrappee.render();
    }
}
