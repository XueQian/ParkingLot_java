package com.thoughtworks.oo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy implements ParkingBoy{
    private List<Parkinglot> parkinglots;

    public SmartParkingBoy(List<Parkinglot> parkinglots) {
        this.parkinglots = parkinglots;
    }

    @Override
    public int park(Car car) {

        Parkinglot parkinglot = Collections
                .max(parkinglots, Comparator.comparing(Parkinglot::getRemainingCount));

        if (parkinglot.getRemainingCount() == 0) {
            return -1;
        }
        parkinglot.park(car);
        return parkinglots.indexOf(parkinglot);
    }
}
