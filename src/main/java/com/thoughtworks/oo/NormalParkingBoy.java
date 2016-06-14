package com.thoughtworks.oo;

import com.thoughtworks.oo.strategy.ParkStrategy;

import java.util.List;

public class NormalParkingBoy implements Parkable {

    protected List<Parkinglot> parkinglots;
    protected ParkStrategy parkStrategy;

    public NormalParkingBoy(List<Parkinglot> parkinglots, ParkStrategy parkStrategy) {
        this.parkinglots = parkinglots;
        this.parkStrategy = parkStrategy;
    }

    public int park(Car car) {
        Parkinglot parkinglot = parkStrategy.getParkingLot(parkinglots);

        if (parkinglot == null || parkinglot.getRemainingCount() == 0) {
            return -1;
        }
        parkinglot.park(car);
        return parkinglots.indexOf(parkinglot);
    }

    @Override
    public void print(String string) {
        String finanlString = string + "-";
        parkinglots.forEach(
                parkinglot -> System.out.println(finanlString + "parkinglot"
                        + parkinglots.indexOf(parkinglot)
                        + "("
                        + parkinglot.getRemainingCount()
                        + "/"
                        + parkinglot.getTotalCount()
                        + ")"
                        + ":")

        );
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
