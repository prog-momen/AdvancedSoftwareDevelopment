package edu.najah.cap.advance.assignments.assignment2.observer;

import edu.najah.cap.advance.assignments.assignment2.Dashboard;

public class DashboardSubscriber implements EventSubscriber {
    private final Dashboard dashboard;

    public DashboardSubscriber(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

    @Override
    public void onEvent(EventNotification n) {
        dashboard.updateMetrics(n.getEvent());
    }
}
