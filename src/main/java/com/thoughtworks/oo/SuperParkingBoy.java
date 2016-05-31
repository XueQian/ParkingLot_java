package com.thoughtworks.oo;

import com.thoughtworks.oo.strategy.ParkStrategy;
import com.thoughtworks.oo.strategy.SuperParkingBoyStrategy;

import java.util.List;

public class SuperParkingBoy extends NormalParkingBoy {

    public SuperParkingBoy(List<Parkinglot> parkinglots) {
        super(parkinglots);
    }

    public int park(Car car) {

        ParkStrategy parkStrategy = new SuperParkingBoyStrategy();
        Parkinglot parkinglot = parkStrategy.getParkingLot(parkinglots);

        if (parkinglot.getRemainingCount() == 0) {
            return -1;
        }
        parkinglot.park(car);
        return parkinglots.indexOf(parkinglot);
    }
}
