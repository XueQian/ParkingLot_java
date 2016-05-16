package com.thoughtworks.oo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy {
    private List<Parkinglot> parkinglots;

    public SmartParkingBoy(List<Parkinglot> parkinglots) {
        this.parkinglots = parkinglots;
    }

    public int park(Car car) {

        Parkinglot parkinglot = Collections
                .max(parkinglots, Comparator.comparing(Parkinglot::getRemainingCount));
        parkinglot.park(car);
        return parkinglots.indexOf(parkinglot);
    }
}
