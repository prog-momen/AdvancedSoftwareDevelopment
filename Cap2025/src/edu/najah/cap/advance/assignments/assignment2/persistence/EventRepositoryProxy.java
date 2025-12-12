package edu.najah.cap.advance.assignments.assignment2.persistence;

public class EventRepositoryProxy implements EventRepository {

    private final EventRepository real;

    public EventRepositoryProxy(EventRepository real) {
        this.real = real;
    }

    @Override
    public void save(String id, String data) {
        // Proxy: تحقق بسيط قبل التخزين
        if (id == null || id.isEmpty()) throw new IllegalArgumentException("id required");
        if (data == null) data = "";

        real.save(id, data);
    }
}
