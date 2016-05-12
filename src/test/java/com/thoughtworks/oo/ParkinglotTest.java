package com.thoughtworks.oo;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParkinglotTest {

    @Test
    public void shouldParkOneCarCorrectly() {

        Parkinglot parkinglot = new Parkinglot(1);

        assertTrue(parkinglot.park(new Car(1)));
    }

    @Test
    public void shouldParkTwoCarsCorrectly() {

        Parkinglot parkinglot = new Parkinglot(2);

        assertTrue(parkinglot.park(new Car(1)));
        assertTrue(parkinglot.park(new Car(2)));
    }

    @Test
    public void shouldNotParkCarWhenParkingLotIsFull() {

        Parkinglot parkinglot = new Parkinglot(0);

        assertFalse(parkinglot.park(new Car(1)));
    }
}
