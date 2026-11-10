package com.aerosaga;
import java.util.UUID;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;

public class DroneMissionStarter {

    public static void main(String[] args) {

        WorkflowServiceStubs service =
                WorkflowServiceStubs.newLocalServiceStubs();

        WorkflowClient client =
                WorkflowClient.newInstance(service);
        String missionId = "aerosaga-drone-mission-" + UUID.randomUUID(); 
        System.out.println("Starting mission with ID: " + missionId);
        DroneWorkflow workflow = client.newWorkflowStub(
                DroneWorkflow.class,
                WorkflowOptions.newBuilder()
                        .setWorkflowId("missionId")
                        .setTaskQueue("AEROSAGA_TASK_QUEUE")
                        .build()
        );
         System.out.println("AeroSaga: Submitting drone mission to Temporal...");
        workflow.takeoff();

        System.out.println("AeroSaga drone mission completed!");
    }
}