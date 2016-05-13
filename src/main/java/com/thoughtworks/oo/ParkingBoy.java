package com.thoughtworks.oo;

import java.util.List;

public class ParkingBoy {

    private List<Parkinglot> parkinglots;

    public ParkingBoy(List<Parkinglot> parkinglots) {
        this.parkinglots = parkinglots;
    }

    public boolean park(Car car) {
        return true;
    }
}
