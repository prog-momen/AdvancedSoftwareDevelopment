package edu.najah.cap.advance.assignments.assignment1.executor;

import edu.najah.cap.advance.assignments.assignment1.connections.Connection;
import edu.najah.cap.advance.assignments.assignment1.job.Job;

public class JobExecutor {

    private final JobStrategyFactory strategyFactory;

    public JobExecutor(JobStrategyFactory strategyFactory) {
        this.strategyFactory = strategyFactory;
    }

    public void executeJob(Job job, Connection connection) {
        System.out.printf("[JobExecutor] Executing job %s (%s)%n",
                job.getName(), job.getType());

        JobStrategy strategy = strategyFactory.getStrategy(job.getType());
        strategy.execute(job, connection);

        System.out.printf("[JobExecutor] Finished job %s%n", job.getName());
    }
}
