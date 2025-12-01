package edu.najah.cap.advance.assignments.assignment1.executor;

import edu.najah.cap.advance.assignments.assignment1.job.Job;
import edu.najah.cap.advance.assignments.assignment1.connections.Connection;

public interface JobStrategy {

    void execute(Job job, Connection connection);
}
