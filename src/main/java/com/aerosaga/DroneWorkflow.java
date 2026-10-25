package com.aerosaga;

import io.temporal.workflow.Workflow;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface DroneWorkflow {

    @WorkflowMethod
    void takeoff();
}