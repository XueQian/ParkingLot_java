package com.thoughtworks.oo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SuperParkingBoy extends NormalParkingBoy {

    public SuperParkingBoy(List<Parkinglot> parkinglots) {
        super(parkinglots);
    }

    public int park(Car car) {

        Parkinglot parkinglot = Collections
                .max(parkinglots, Comparator.comparing(Parkinglot::getRemainingSpaceRate));

        if (parkinglot.getRemainingCount() == 0) {
            return -1;
        }
        parkinglot.park(car);
        return parkinglots.indexOf(parkinglot);
    }
}
