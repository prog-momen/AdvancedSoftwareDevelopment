package edu.najah.cap.advance.assignments.assignment2.persistence;

public class DatabaseEventRepository implements EventRepository {

    private final ConnectionPool pool;

    public DatabaseEventRepository(ConnectionPool pool) {
        this.pool = pool;
    }

    @Override
    public void save(String id, String data) {
        ConnectionPool.PooledConnection c = pool.acquire();
        try {
            c.getDb().save(c.getId(), id, data);
        } finally {
            pool.release(c);
        }
    }
}
