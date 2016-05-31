package com.thoughtworks.oo;

import com.thoughtworks.oo.strategy.NormalParkingBoyStrategy;

import java.util.List;

public class NormalParkingBoy {

    protected List<Parkinglot> parkinglots;

    public NormalParkingBoy(List<Parkinglot> parkinglots) {
        this.parkinglots = parkinglots;
    }

    public int park(Car car) {
        NormalParkingBoyStrategy parkStrategy = new NormalParkingBoyStrategy();
        Parkinglot parkinglot = parkStrategy.getParkingLot(parkinglots);

        if (parkinglot == null) {
            return -1;
        }
        parkinglot.park(car);
        return parkinglots.indexOf(parkinglot);
    }

    public Car unPark(int number) {

        Parkinglot parkinglot = parkinglots.stream()
                .filter(parkinglot1 -> parkinglot1.isCarExist(number))
                .findAny()
                .orElse(null);

        if (parkinglot == null) {
            return null;
        }
        return parkinglot.unPark(number);
    }
}
