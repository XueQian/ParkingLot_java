package com.thoughtworks.oo;

import java.util.List;

public class ParkingPrinter {
    public void print(ParkingManager parkingManager) {
        List<Parkable> parkingBoyList = parkingManager.parkingBoyList;

        System.out.println("parkingManager:");
        parkingBoyList.forEach(parkingBoy -> System.out.println("-parkingBoy" + parkingBoyList.indexOf(parkingBoy) + ":"));
    }
}
