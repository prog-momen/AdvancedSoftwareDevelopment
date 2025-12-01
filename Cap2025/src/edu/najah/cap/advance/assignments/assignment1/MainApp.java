package edu.najah.cap.advance.assignments.assignment1;

import edu.najah.cap.advance.assignments.assignment1.executor.JobExecutor;
import edu.najah.cap.advance.assignments.assignment1.executor.JobStrategyFactory;
import edu.najah.cap.advance.assignments.assignment1.executor.SecuredJobExecutor;
import edu.najah.cap.advance.assignments.assignment1.job.Job;
import edu.najah.cap.advance.assignments.assignment1.model.User;
import edu.najah.cap.advance.assignments.assignment1.templates.TemplateManager;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("=== TMPS Refactored App ===");

        TemplateManager templateManager = new TemplateManager();
        JobStrategyFactory factory = new JobStrategyFactory();
        JobExecutor realExecutor = new JobExecutor(factory);
        SecuredJobExecutor securedExecutor = new SecuredJobExecutor(realExecutor);

        User alice = new User("Alice", Arrays.asList("EMAIL", "REPORT"));

        System.out.println("\n--- Create Report Job from template ---");
        Job reportJob = templateManager
                .buildReportJobTemplate("MonthlyReport", "format=PDF;brand=TaskMaster")
                .createJobInstance();
        reportJob.setRequestedBy(alice);

        System.out.println("\n--- Execute job (via Proxy) ---");
        securedExecutor.execute(reportJob);

        System.out.println("\n--- Create Email Job from template ---");
        Job emailJob = templateManager
                .buildEmailJobTemplate("Monthly Email Report", "format=PDF;all=true")
                .createJobInstance();
        emailJob.setRequestedBy(alice);

        System.out.println("\n--- Execute job (via Proxy) ---");
        securedExecutor.execute(emailJob);
    }
}
