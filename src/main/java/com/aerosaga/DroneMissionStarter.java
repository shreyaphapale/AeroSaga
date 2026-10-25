package com.aerosaga;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;

public class DroneMissionStarter {

    public static void main(String[] args) {

        WorkflowServiceStubs service =
                WorkflowServiceStubs.newLocalServiceStubs();

        WorkflowClient client =
                WorkflowClient.newInstance(service);

        DroneWorkflow workflow = client.newWorkflowStub(
                DroneWorkflow.class,
                WorkflowOptions.newBuilder()
                        .setWorkflowId("aerosaga-drone-mission-001")
                        .setTaskQueue("AEROSAGA_TASK_QUEUE")
                        .build()
        );

        workflow.takeoff();

        System.out.println("AeroSaga drone mission completed!");
    }
}