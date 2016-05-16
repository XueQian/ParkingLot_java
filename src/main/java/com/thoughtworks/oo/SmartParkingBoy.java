package com.thoughtworks.oo;

import java.util.List;

public class SmartParkingBoy {
    private List<Parkinglot> parkinglots;

    public SmartParkingBoy(List<Parkinglot> parkinglots) {
        this.parkinglots = parkinglots;
    }

    public boolean park(Car car) {
        return true;
    }
}
