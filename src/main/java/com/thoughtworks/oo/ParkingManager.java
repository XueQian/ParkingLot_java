package com.thoughtworks.oo;

import java.util.List;

public class ParkingManager {
    protected List<NormalParkingBoy> parkingBoyList;

    public ParkingManager(List<NormalParkingBoy> parkingBoyList) {
        this.parkingBoyList = parkingBoyList;
    }

    public int park(Car car) {
        for (NormalParkingBoy parkingBoy : parkingBoyList) {
            if (parkingBoy.park(car) != -1) {
                return 0;
            }
        }
        return -1;
    }
}
