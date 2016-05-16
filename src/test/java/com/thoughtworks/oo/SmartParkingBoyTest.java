package com.thoughtworks.oo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SmartParkingBoyTest {

    @Test
    public void shouldParkOneCarCorrectly() {

        List<Parkinglot> parkinglots = new ArrayList<Parkinglot>();
        parkinglots.add(new Parkinglot(2));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkinglots);
        assertThat(smartParkingBoy.park(new Car(1)), is(0));
    }

    @Test
    public void shouldParkOneCarToTheFirstBiggestSpareParkingLotCorrectly() {
        List<Parkinglot> parkinglots = new ArrayList<Parkinglot>();
        Parkinglot parkinglot = new Parkinglot(2);
        Parkinglot parkinglot1 = new Parkinglot(2);
        parkinglot.park(new Car(1));
        parkinglots.add(parkinglot);
        parkinglots.add(parkinglot1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkinglots);

        assertThat(smartParkingBoy.park(new Car(2)), is(1));
    }
}
