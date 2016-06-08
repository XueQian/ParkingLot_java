package com.thoughtworks.oo;

import java.util.List;

public class ParkingManager implements Parkable {
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
    public void print() {

        System.out.println("parkingManager:");
        parkingBoyList.stream()
                .peek(parkingBoy -> System.out.println("-parkingBoy" + parkingBoyList.indexOf(parkingBoy) + ":"))
                .forEach(Parkable::print);
    }
}
