package com.thoughtworks.oo;

import java.util.ArrayList;
import java.util.List;

public class Parkinglot {

    private List<Car> parkedCars = new ArrayList<Car>();
    private int remainingCount;

    public Parkinglot(int remainingCount) {
        this.remainingCount = remainingCount;
    }

    public boolean park(Car car) {

        if (remainingCount > 0) {
            remainingCount--;
            parkedCars.add(car);
            return true;
        } else {
            return false;
        }
    }

    public Car unPark(int number) {
        return parkedCars.get(0);
    }
}
