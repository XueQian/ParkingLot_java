package com.thoughtworks.oo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SuperParkingBoyTest {

    @Test
    public void shouldParkOneCarCorrectly() {

        List<Parkinglot> parkinglots = new ArrayList<Parkinglot>();
        parkinglots.add(new Parkinglot(2));

        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkinglots);

        assertThat(superParkingBoy.park(new Car(1)), is(0));
    }

    @Test
    public void shouldParkOneCarToTheMaxRestSpaceParkingLotCorrectly() {

        List<Parkinglot> parkinglots = new ArrayList<Parkinglot>();
        Parkinglot parkinglot = new Parkinglot(3);
        Parkinglot parkinglot1 = new Parkinglot(4);
        parkinglot.park(new Car(1));
        parkinglot.park(new Car(2));
        parkinglot1.park(new Car(3));
        parkinglots.add(parkinglot);
        parkinglots.add(parkinglot1);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkinglots);

        assertThat(superParkingBoy.park(new Car(4)), is(1));
    }

    @Test
    public void shouldNotParkCarWhenParkingLotIsFull() {

        List<Parkinglot> parkinglots = new ArrayList<Parkinglot>();
        parkinglots.add(new Parkinglot(0));
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkinglots);

        assertThat(superParkingBoy.park(new Car(1)), is(-1));
    }
}
