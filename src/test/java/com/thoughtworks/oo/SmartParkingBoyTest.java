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
        assertThat(smartParkingBoy.park(new Car(1)), is(true));
    }
}
