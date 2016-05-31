package com.thoughtworks.oo.strategy;

import com.thoughtworks.oo.Parkinglot;

import java.util.List;

public class NormalParkingBoyStrategy implements ParkStrategy {

    @Override
    public Parkinglot getParkingLot(List<Parkinglot> parkinglots) {
        return parkinglots.stream()
                .filter(Parkinglot::isFull)
                .findFirst()
                .orElse(null);
    }
}
