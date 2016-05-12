package com.thoughtworks.oo;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ParkinglotTest {
    @Test
    public void shouldParkOneCarCorrectly() {

        Parkinglot parkinglot = new Parkinglot();

        assertTrue(parkinglot.park(new Car(1)));
    }
}
