package com.thoughtworks.oo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParkingBoyTest {

    @Test
    public void shouldParkOneCarCorrectly() {

        List<Parkinglot> parkinglots = new ArrayList<Parkinglot>();
        parkinglots.add(new Parkinglot(2));
        ParkingBoy parkingBoy = new ParkingBoy(parkinglots);

        assertThat(parkingBoy.park(new Car(1)), is(0));
    }

    @Test
    public void shouldParkOneCarToTheFirstUnFullParkinglotCorrectly() {

        List<Parkinglot> parkinglots = new ArrayList<Parkinglot>();
        parkinglots.add(new Parkinglot(0));
        parkinglots.add(new Parkinglot(2));
        parkinglots.add(new Parkinglot(2));
        ParkingBoy parkingBoy = new ParkingBoy(parkinglots);

        assertThat(parkingBoy.park(new Car(1)), is(1));
    }
}
