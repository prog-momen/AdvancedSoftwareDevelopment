package edu.najah.cap.advance.assignments.assignment1.executor;

import edu.najah.cap.advance.assignments.assignment1.connections.Connection;
import edu.najah.cap.advance.assignments.assignment1.connections.ConnectionPool;
import edu.najah.cap.advance.assignments.assignment1.job.Job;
import edu.najah.cap.advance.assignments.assignment1.model.User;

public class SecuredJobExecutor {

    private final JobExecutor realExecutor;
    private final ConnectionPool pool;

    public SecuredJobExecutor(JobExecutor realExecutor) {
        this.realExecutor = realExecutor;
        this.pool = ConnectionPool.getInstance();
    }

    public void execute(Job job) {
        User user = job.getRequestedBy();

        if (!hasPermission(user, job)) {
            System.out.printf("[SecuredJobExecutor] User %s is NOT allowed to run job type %s%n",
                    user != null ? user.getName() : "unknown",
                    job.getType());
            return;
        }

        long start = System.currentTimeMillis();
        Connection conn = null;

        try {
            conn = pool.acquire();
            System.out.printf("[SecuredJobExecutor] Starting job %s for user %s%n",
                    job.getName(), user != null ? user.getName() : "unknown");

            realExecutor.executeJob(job, conn);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("[SecuredJobExecutor] Failed to acquire connection from pool");
        } finally {
            if (conn != null) {
                pool.release(conn);
            }
            long end = System.currentTimeMillis();
            System.out.printf("[SecuredJobExecutor] Job %s finished in %d ms%n",
                    job.getName(), (end - start));
        }
    }

    private boolean hasPermission(User user, Job job) {
        if (user == null) return false;
        String requiredPerm = job.getType().name(); // EMAIL, DATA, REPORT
        return user.hasPermission(requiredPerm);
    }
}
