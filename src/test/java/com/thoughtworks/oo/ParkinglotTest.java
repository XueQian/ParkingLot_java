package com.thoughtworks.oo;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParkinglotTest {

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

        Parkinglot parkingLot = new Parkinglot(parkingLotSpace);

        assertTrue(parkingLot.park(car1));
    }

    @Test
    public void shouldParkTwoCarsCorrectly() {

        Parkinglot parkingLot = new Parkinglot(parkingLotSpace);

        assertTrue(parkingLot.park(car1));
        assertTrue(parkingLot.park(car2));
    }

    @Test
    public void shouldNotParkCarWhenParkingLotIsFull() {

        Parkinglot parkingLot = new Parkinglot(0);

        assertFalse(parkingLot.park(car1));
    }

    @Test
    public void shouldUnParkOneValidCarCorrectly() {

        Parkinglot parkingLot = new Parkinglot(parkingLotSpace);
        parkingLot.park(car1);

        assertThat(parkingLot.unPark(validCarNumber1), is(car1));
    }

    @Test
    public void shouldNotUnParkOneInvalidCar() {

        Parkinglot parkingLot = new Parkinglot(parkingLotSpace);
        parkingLot.park(car1);

        assertThat(parkingLot.unPark(invalidCarNumber), is((Car) null));
    }

    @Test
    public void shouldParkOneCarThenUnParkTheCarThenParkTheCarAgainCorrectly() {

        Parkinglot parkinglot = new Parkinglot(parkingLotSpace);
        parkinglot.park(car1);
        parkinglot.unPark(validCarNumber1);

        assertTrue(parkinglot.park(car1));
    }
}
