package edu.najah.cap.advance.assignments.assignment2;

import edu.najah.cap.advance.assignments.assignment2.observer.*;
import edu.najah.cap.advance.assignments.assignment2.persistence.*;
import edu.najah.cap.advance.assignments.assignment2.pipeline.DefaultEventProcessingPipeline;
import edu.najah.cap.advance.assignments.assignment2.strategy.EventHandlerFactory;

public class App {
    public static void main(String[] args) {

        // Observer wiring
        EventPublisher publisher = new EventPublisher();
        publisher.subscribe(new DashboardSubscriber(new Dashboard()));
        publisher.subscribe(new LoggerSubscriber(new Logger()));

        // Proxy + Connection Pool
        ConnectionPool pool = new ConnectionPool(3);
        EventRepository realRepo = new DatabaseEventRepository(pool);
        EventRepository repoProxy = new EventRepositoryProxy(realRepo);

        // Strategy
        EventHandlerFactory factory = new EventHandlerFactory();

        // Template Method Pipeline
        DefaultEventProcessingPipeline pipeline =
                new DefaultEventProcessingPipeline(factory, repoProxy, publisher);

        EventProcessor processor = new EventProcessor(pipeline);

        Event e1 = new Event("USER", "user-click");
        e1.setEncrypt(true);
        e1.setAddMetadata(true);
        e1.setMetadata("u=42");
        processor.process(e1);

        Event e2 = new Event("SECURITY", "failed-login");
        e2.setCompress(true);
        processor.process(e2);
    }
}
