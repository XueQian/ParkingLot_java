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

        if (remainingCount > 0 && !isCarExist(car.getNumber())) {
            parkOneCar(car);
            return true;
        }
        return false;
    }

    private void parkOneCar(Car car) {
        remainingCount--;
        parkedCars.add(car);
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
