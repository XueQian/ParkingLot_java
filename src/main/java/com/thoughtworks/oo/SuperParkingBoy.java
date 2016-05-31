package com.thoughtworks.oo;

import com.thoughtworks.oo.strategy.ParkStrategy;

import java.util.List;

public class SuperParkingBoy extends NormalParkingBoy {

    public SuperParkingBoy(List<Parkinglot> parkinglots, ParkStrategy parkStrategy) {
        super(parkinglots, parkStrategy);
    }

    public int park(Car car) {

        Parkinglot parkinglot = parkStrategy.getParkingLot(parkinglots);

        if (parkinglot.getRemainingCount() == 0) {
            return -1;
        }
        parkinglot.park(car);
        return parkinglots.indexOf(parkinglot);
    }
}
