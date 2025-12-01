package edu.najah.cap.advance.assignments.assignment1.executor;

import edu.najah.cap.advance.assignments.assignment1.job.JobType;

public class JobStrategyFactory {

    public JobStrategy getStrategy(JobType type) {
        return switch (type) {
            case EMAIL -> new EmailJobStrategy();
            case DATA -> new DataProcessingStrategy();
            case REPORT -> new ReportGenerationStrategy();
        };
    }
}
