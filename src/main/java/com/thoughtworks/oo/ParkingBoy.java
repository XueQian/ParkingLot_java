package com.thoughtworks.oo;

import java.util.List;

public class ParkingBoy {

    private List<Parkinglot> parkinglots;

    public ParkingBoy(List<Parkinglot> parkinglots) {
        this.parkinglots = parkinglots;
    }

    public int park(Car car) {

        Parkinglot parkinglot1 = parkinglots.stream().
                filter(Parkinglot::isFull)
                .findFirst()
                .orElse(null);

        parkinglot1.park(car);
        return parkinglots.indexOf(parkinglot1);
    }
}
