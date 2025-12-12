package edu.najah.cap.advance.assignments.assignment2;

import edu.najah.cap.advance.assignments.assignment2.pipeline.AbstractEventProcessingPipeline;

public class EventProcessor {
    private final AbstractEventProcessingPipeline pipeline;

    public EventProcessor(AbstractEventProcessingPipeline pipeline) {
        this.pipeline = pipeline;
    }

    public void process(Event e) {
        pipeline.process(e);
    }
}
