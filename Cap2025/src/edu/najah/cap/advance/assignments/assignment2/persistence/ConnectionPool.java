package edu.najah.cap.advance.assignments.assignment2.persistence;

import java.util.ArrayDeque;
import java.util.Queue;

public class ConnectionPool {

    // كلاس داخلي يمثل كونكشن عليه ID
    public static class PooledConnection {
        private final String id;
        private final Database db;

        public PooledConnection(String id, Database db) {
            this.id = id;
            this.db = db;
        }

        public String getId() { return id; }
        public Database getDb() { return db; }
    }

    private final Queue<PooledConnection> pool = new ArrayDeque<>();
    private int counter = 0;

    public ConnectionPool(int size) {
        for (int i = 0; i < size; i++) {
            pool.add(new PooledConnection("C-" + (++counter), new Database()));
        }
    }

    public synchronized PooledConnection acquire() {
        if (pool.isEmpty()) {
            return new PooledConnection("C-" + (++counter), new Database());
        }
        return pool.poll();
    }

    public synchronized void release(PooledConnection c) {
        pool.add(c);
    }
}
