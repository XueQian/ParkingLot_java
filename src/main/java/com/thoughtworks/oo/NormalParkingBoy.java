package com.thoughtworks.oo;

import java.util.List;

public class NormalParkingBoy implements ParkingBoy {

    private List<Parkinglot> parkinglots;

    public NormalParkingBoy(List<Parkinglot> parkinglots) {
        this.parkinglots = parkinglots;
    }

    @Override
    public int park(Car car) {

        Parkinglot parkinglot = parkinglots.stream()
                .filter(Parkinglot::isFull)
                .findFirst()
                .orElse(null);

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
