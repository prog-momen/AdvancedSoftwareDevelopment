package  edu.najah.cap.advance.assignments.assignment2.pipeline;

import edu.najah.cap.advance.assignments.assignment2.Event;
import edu.najah.cap.advance.assignments.assignment2.decorator.EventPayload;

public abstract class AbstractEventProcessingPipeline {

    public final void process(Event e) {
        if (!validate(e)) {
            System.out.println("Invalid event");
            return;
        }

        EventPayload payload = buildPayload(e);
        String data = payload.render();

        assignId(e, data);
        persist(e, data);
        handle(e);
        notifySubscribers(e);
    }

    protected boolean validate(Event e) {
        return e != null && e.getPayload() != null && !e.getPayload().isEmpty();
    }

    protected void assignId(Event e, String data) {
        e.setId(System.currentTimeMillis() + "-" + Math.abs(data.hashCode()));
    }

    protected abstract EventPayload buildPayload(Event e);
    protected abstract void persist(Event e, String data);
    protected abstract void handle(Event e);
    protected abstract void notifySubscribers(Event e);
}
