package com.aerosaga;

import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;

public class DroneWorkflowImpl implements DroneWorkflow {

    private final DroneActivities activities =
            Workflow.newActivityStub(
                    DroneActivities.class,
                    ActivityOptions.newBuilder()
                            .setStartToCloseTimeout(Duration.ofMinutes(1))
                            .build()
            );

    @Override
    public void takeoff() {

        Workflow.getLogger(DroneWorkflowImpl.class)
                .info("AeroSaga mission started.");

        activities.takeoff();

        Workflow.getLogger(DroneWorkflowImpl.class)
                .info("Takeoff completed.");

        activities.navigateToDestination();

        Workflow.getLogger(DroneWorkflowImpl.class)
                .info("Navigation completed.");

        activities.deliverPackage();

        Workflow.getLogger(DroneWorkflowImpl.class)
                .info("Package delivery completed. AeroSaga mission successful!");
    }
}
