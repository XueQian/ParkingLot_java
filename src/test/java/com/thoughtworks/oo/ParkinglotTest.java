package com.thoughtworks.oo;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParkingLotTest {

    private int validCarNumber1;
    private int validCarNumber2;
    private int invalidCarNumber;
    private Car car1;
    private Car car2;
    private int parkingLotSpace;

    @Before
    public void setUp() {
        validCarNumber1 = 1111;
        validCarNumber2 = 2222;
        invalidCarNumber = 3333;
        car1 = new Car(validCarNumber1);
        car2 = new Car(validCarNumber2);
        parkingLotSpace = 5;
    }

    @Test
    public void shouldParkOneCarCorrectly() {

        ParkingLot parkingLot = new ParkingLot(parkingLotSpace);

        assertTrue(parkingLot.park(car1));
    }

    @Test
    public void shouldParkTwoCarsCorrectly() {

        ParkingLot parkingLot = new ParkingLot(parkingLotSpace);

        assertTrue(parkingLot.park(car1));
        assertTrue(parkingLot.park(car2));
    }

    @Test
    public void shouldNotParkCarWhenParkingLotIsFull() {

        ParkingLot parkingLot = new ParkingLot(0);

        assertFalse(parkingLot.park(car1));
    }

    @Test
    public void shouldNotParkOneCarWhenTheCarExistInParkinglot() {

        ParkingLot parkingLot = new ParkingLot(parkingLotSpace);

        assertTrue(parkingLot.park(car1));
        assertFalse(parkingLot.park(car1));
    }

    @Test
    public void shouldUnParkOneValidCarCorrectly() {

        ParkingLot parkingLot = new ParkingLot(parkingLotSpace);
        parkingLot.park(car1);

        assertThat(parkingLot.unPark(validCarNumber1), is(car1));
    }

    @Test
    public void shouldNotUnParkOneInvalidCar() {

        ParkingLot parkingLot = new ParkingLot(parkingLotSpace);
        parkingLot.park(car1);

        assertThat(parkingLot.unPark(invalidCarNumber), is((Car) null));
    }
}
