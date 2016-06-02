package com.thoughtworks.oo;

import java.util.List;

public class SuperParkingManager {
    private List<ParkingManager> parkingManagers;

    public SuperParkingManager(List<ParkingManager> parkingManagers) {
        this.parkingManagers = parkingManagers;
    }

    public int park(Car car) {
        for (ParkingManager parkingManager : parkingManagers) {
            if (parkingManager.park(car) != -1) {
                return 0;
            }
        }
        return -1;
    }
}
