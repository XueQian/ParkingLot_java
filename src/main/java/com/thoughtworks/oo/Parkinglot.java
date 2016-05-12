package com.thoughtworks.oo;

public class Parkinglot {

    private Car parkedCar;

    public boolean park(Car car) {

        parkedCar = car;
        return true;
    }
}
