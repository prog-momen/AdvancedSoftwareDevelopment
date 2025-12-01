package edu.najah.cap.advance.assignments.assignment1.connections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {

    private static final int MAX_CONNECTIONS = 10;
    private static ConnectionPool instance;

    private final BlockingQueue<Connection> pool;

    private ConnectionPool() {
        pool = new ArrayBlockingQueue<>(MAX_CONNECTIONS);
        for (int i = 1; i <= MAX_CONNECTIONS; i++) {
            pool.add(new Connection("Conn-" + i));
        }
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public Connection acquire() throws InterruptedException {
        Connection c = pool.take(); // block if none available
        System.out.printf("[ConnectionPool] Acquired %s%n", c.getId());
        return c;
    }

    public void release(Connection c) {
        if (c == null) return;
        boolean ok = pool.offer(c);
        if (ok) {
            System.out.printf("[ConnectionPool] Released %s%n", c.getId());
        } else {
            System.out.printf("[ConnectionPool] Pool full, dropping %s%n", c.getId());
        }
    }
}
