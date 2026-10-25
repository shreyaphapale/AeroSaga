package com.aerosaga;

public class DroneActivitiesImpl implements DroneActivities {

    @Override
    public void takeoff() {
        System.out.println("🚁 AeroSaga drone is taking off...");
        System.out.println("Altitude increasing...");
        System.out.println("Takeoff completed successfully!");
    }
}