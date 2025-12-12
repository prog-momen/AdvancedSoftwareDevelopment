package edu.najah.cap.advance.assignments.assignment2.pipeline;

import edu.najah.cap.advance.assignments.assignment2.Event;
import edu.najah.cap.advance.assignments.assignment2.decorator.*;
import edu.najah.cap.advance.assignments.assignment2.observer.EventNotification;
import edu.najah.cap.advance.assignments.assignment2.observer.EventPublisher;
import edu.najah.cap.advance.assignments.assignment2.persistence.EventRepository;
import edu.najah.cap.advance.assignments.assignment2.strategy.EventHandlerFactory;
import edu.najah.cap.advance.assignments.assignment2.strategy.EventHandlerStrategy;

public class DefaultEventProcessingPipeline extends AbstractEventProcessingPipeline {

    private final EventHandlerFactory handlerFactory;
    private final EventRepository repository;
    private final EventPublisher publisher;

    public DefaultEventProcessingPipeline(EventHandlerFactory handlerFactory,
                                          EventRepository repository,
                                          EventPublisher publisher) {
        this.handlerFactory = handlerFactory;
        this.repository = repository;
        this.publisher = publisher;
    }

    @Override
    protected EventPayload buildPayload(Event e) {
        // Decorator: لفّ البيانات حسب الخيارات
        EventPayload payload = new RawPayload(e.getPayload());

        if (e.isEncrypt()) {
            payload = new EncryptedPayloadDecorator(payload);
        }

        if (e.isCompress()) {
            payload = new CompressedPayloadDecorator(payload);
        }

        if (e.isAddMetadata()) {
            payload = new MetadataPayloadDecorator(payload, e.getMetadata());
        }

        return payload;
    }

    @Override
    protected void persist(Event e, String data) {
        repository.save(e.getId(), data);
    }

    @Override
    protected void handle(Event e) {
        // Strategy: اختيار المعالج حسب نوع الحدث
        EventHandlerStrategy strategy = handlerFactory.get(e.getType());
        strategy.handle(e);
    }

    @Override
    protected void notifySubscribers(Event e) {
        // Observer + Prototype
        publisher.publish(new EventNotification(e.copy()));
    }
}
