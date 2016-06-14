package com.thoughtworks.oo;

import java.util.List;

public class ParkingManager implements Parkable {
    public List<Parkable> getParkingBoyList() {
        return parkingBoyList;
    }

    protected List<Parkable> parkingBoyList;

    public ParkingManager(List<Parkable> parkingBoyList) {
        this.parkingBoyList = parkingBoyList;
    }

    @Override
    public int park(Car car) {
        for (Parkable parkingBoy : parkingBoyList) {
            if (parkingBoy.park(car) != -1) {
                return 0;
            }
        }
        return -1;
    }

    @Override
    public void print(String string) {
        System.out.println(string + "parkingManager:");
        if (parkingBoyList.size() > 0) {

            if (parkingBoyList.get(0).getClass() == ParkingManager.class) {
                parkingBoyList.stream()
                        .forEach((parkable) -> parkable.print("-"));

            } else {
                String finalString = string + "-";
                parkingBoyList.stream()
                        .peek(parkingBoy -> System.out.println(finalString + "parkingBoy" + parkingBoyList.indexOf(parkingBoy) + ":"))
                        .forEach((parkable) -> parkable.print(finalString));
            }
        }
    }
}
