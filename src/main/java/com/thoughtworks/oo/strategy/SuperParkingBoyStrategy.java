package com.thoughtworks.oo.strategy;

import com.thoughtworks.oo.Parkinglot;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SuperParkingBoyStrategy implements ParkStrategy {

    @Override
    public Parkinglot getParkingLot(List<Parkinglot> parkinglots) {
        return Collections
                .max(parkinglots, Comparator.comparing(Parkinglot::getRemainingSpaceRate));
    }
}
