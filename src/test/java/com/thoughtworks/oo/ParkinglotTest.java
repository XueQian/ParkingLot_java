package com.thoughtworks.oo;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParkingLotTest {

    @Test
    public void shouldParkOneCarCorrectly() {

        ParkingLot parkingLot = new ParkingLot(1);

        assertTrue(parkingLot.park(new Car(1)));
    }

    @Test
    public void shouldParkTwoCarsCorrectly() {

        ParkingLot parkingLot = new ParkingLot(2);

        assertTrue(parkingLot.park(new Car(1)));
        assertTrue(parkingLot.park(new Car(2)));
    }

    @Test
    public void shouldNotParkCarWhenParkingLotIsFull() {

        ParkingLot parkingLot = new ParkingLot(0);

        assertFalse(parkingLot.park(new Car(1)));
    }

    @Test
    public void shouldNotParkOneCarWhenTheCarExistInParkinglot() {

        ParkingLot parkingLot = new ParkingLot(2);

        assertTrue(parkingLot.park(new Car(1)));
        assertFalse(parkingLot.park(new Car(1)));
    }

    @Test
    public void shouldUnParkOneValidCarCorrectly() {

        ParkingLot parkingLot = new ParkingLot(1);

        Car car = new Car(1);
        parkingLot.park(car);

        assertThat(parkingLot.unPark(1), is(car));
    }

    @Test
    public void shouldNotUnParkOneInvalidCar() {

        ParkingLot parkingLot = new ParkingLot(1);

        Car car = new Car(1);
        parkingLot.park(car);

        assertThat(parkingLot.unPark(2), is((Car) null));
    }
}
