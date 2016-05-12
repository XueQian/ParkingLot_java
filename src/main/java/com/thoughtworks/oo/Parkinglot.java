package com.thoughtworks.oo;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private List<Car> parkedCars = new ArrayList<Car>();
    private int remainingCount;

    public ParkingLot(int remainingCount) {
        this.remainingCount = remainingCount;
    }

    public boolean park(Car car) {

        if (remainingCount > 0 && !isCarExist(car.getNumber())) {
            remainingCount--;
            parkedCars.add(car);
            return true;
        } else {
            return false;
        }
    }

    public Car unPark(int number) {

        for (Car car : parkedCars) {
            if (number == car.getNumber()) {
                return car;
            }
        }
        return null;
    }

    private Boolean isCarExist(int number) {

        for (Car car : parkedCars) {
            if (number == car.getNumber()) {
                return true;
            }
        }
        return false;
    }
}
