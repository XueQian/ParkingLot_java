package com.thoughtworks.oo;

import java.util.ArrayList;
import java.util.List;

public class Parkinglot {

    private List<Car> parkedCars = new ArrayList<Car>();

    public boolean park(Car car) {

        parkedCars.add(car);
        return true;
    }
}
