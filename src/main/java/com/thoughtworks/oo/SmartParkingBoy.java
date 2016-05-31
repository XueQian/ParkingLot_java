package com.thoughtworks.oo;

import com.thoughtworks.oo.strategy.ParkStrategy;

import java.util.List;

public class SmartParkingBoy extends NormalParkingBoy {

    public SmartParkingBoy(List<Parkinglot> parkinglots, ParkStrategy parkStrategy) {
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
