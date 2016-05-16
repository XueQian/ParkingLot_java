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
                parkedCars.remove(car);
                return car;
            }
        }
        return null;
    }

    public boolean isCarExist(int number) {

        Car car = parkedCars.stream()
                .filter(car1 -> car1.getNumber() == number)
                .findAny()
                .orElse(null);
        return car != null;
    }

    public boolean isFull() {
        return remainingCount > 0;
    }
}
