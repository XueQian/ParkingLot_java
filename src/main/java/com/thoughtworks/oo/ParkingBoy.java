package com.thoughtworks.oo;

import java.util.List;

public class ParkingBoy {

    private List<Parkinglot> parkinglots;

    public ParkingBoy(List<Parkinglot> parkinglots) {
        this.parkinglots = parkinglots;
    }

    public int park(Car car) {

        Parkinglot parkinglot = parkinglots.stream().
                filter(Parkinglot::isFull)
                .findFirst()
                .orElse(null);

        if (parkinglot == null) {
            return -1;
        }
        parkinglot.park(car);
        return parkinglots.indexOf(parkinglot);
    }
}
