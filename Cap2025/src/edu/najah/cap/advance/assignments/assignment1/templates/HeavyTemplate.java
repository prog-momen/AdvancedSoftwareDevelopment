package edu.najah.cap.advance.assignments.assignment1.templates;

import edu.najah.cap.advance.assignments.assignment1.job.Job;
import edu.najah.cap.advance.assignments.assignment1.job.JobType;

public class HeavyTemplate implements JobPrototype, Cloneable {

    private final JobType type;
    private final String name;
    private final String config;
    private final String templateBody;

    public HeavyTemplate(JobType type, String name, String config, String templateBody) {
        this.type = type;
        this.name = name;
        this.config = config;

        System.out.println("[HeavyTemplate] Building heavy template for: " + name);
        try {
            Thread.sleep(3000); // simulate heavy template creation
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        this.templateBody = templateBody;
    }
public Job createJobInstance() {
    return new Job(
        templateBody + "-" + type + "-" + System.currentTimeMillis(),
        type,
        name,
        config
    );
}

    @Override
    public Job cloneJob() {
        return new Job(
                templateBody + "-" + type + "-" + System.currentTimeMillis(),
                type,
                name,
                config
        );
    }

    @Override
    public HeavyTemplate clone() {
        try {
            return (HeavyTemplate) super.clone();
        } catch (CloneNotSupportedException e) {
            return new HeavyTemplate(type, name, config, templateBody);
        }
    }

    public JobType getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}