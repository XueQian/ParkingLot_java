package com.thoughtworks.oo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class ParkingBoyTest {

    @Test
    public void shouldParkOneCarCorrectly() {

        List<Parkinglot> parkinglots = new ArrayList<Parkinglot>();
        ParkingBoy parkingBoy = new ParkingBoy(parkinglots);

        assertTrue(parkingBoy.park(new Car(1)));
    }
}
