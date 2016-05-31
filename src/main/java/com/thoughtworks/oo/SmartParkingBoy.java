package com.thoughtworks.oo;

import com.thoughtworks.oo.strategy.ParkStrategy;
import com.thoughtworks.oo.strategy.SmartParkingBoyStrategy;

import java.util.List;

public class SmartParkingBoy extends NormalParkingBoy {

    public SmartParkingBoy(List<Parkinglot> parkinglots) {
        super(parkinglots);
    }

    public int park(Car car) {

        ParkStrategy parkStrategy = new SmartParkingBoyStrategy();
        Parkinglot parkinglot = parkStrategy.getParkingLot(parkinglots);

        if (parkinglot.getRemainingCount() == 0) {
            return -1;
        }
        parkinglot.park(car);
        return parkinglots.indexOf(parkinglot);
    }
}
