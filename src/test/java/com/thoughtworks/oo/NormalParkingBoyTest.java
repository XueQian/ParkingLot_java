package com.thoughtworks.oo;

import com.thoughtworks.oo.strategy.NormalParkingBoyStrategy;
import com.thoughtworks.oo.strategy.ParkStrategy;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NormalParkingBoyTest {
    private ParkStrategy normalParkingBoyStrategy;

    @Before
    public void setUp() {
        normalParkingBoyStrategy = new NormalParkingBoyStrategy();
    }

    @Test
    public void shouldParkOneCarCorrectly() {

        List<Parkinglot> parkinglots = new ArrayList<Parkinglot>();
        parkinglots.add(new Parkinglot(2));
        NormalParkingBoy parkingBoy = new NormalParkingBoy(parkinglots, normalParkingBoyStrategy);

        assertThat(parkingBoy.park(new Car(1)), is(0));
    }

    @Test
    public void shouldParkOneCarToTheFirstUnFullParkinglotCorrectly() {

        List<Parkinglot> parkinglots = new ArrayList<Parkinglot>();
        parkinglots.add(new Parkinglot(0));
        parkinglots.add(new Parkinglot(2));
        parkinglots.add(new Parkinglot(2));
        NormalParkingBoy parkingBoy = new NormalParkingBoy(parkinglots, normalParkingBoyStrategy);

        assertThat(parkingBoy.park(new Car(1)), is(1));
    }

    @Test
    public void shouldNotParkCarWhenAllParkingLotIsFull() {

        List<Parkinglot> parkinglots = new ArrayList<Parkinglot>();
        parkinglots.add(new Parkinglot(0));
        parkinglots.add(new Parkinglot(0));
        NormalParkingBoy parkingBoy = new NormalParkingBoy(parkinglots, normalParkingBoyStrategy);

        assertThat(parkingBoy.park(new Car(1)), is(-1));
    }

    @Test
    public void shouldUnParkOneValidCarCorrectly() {

        List<Parkinglot> parkinglots = new ArrayList<Parkinglot>();
        parkinglots.add(new Parkinglot(2));
        NormalParkingBoy parkingBoy = new NormalParkingBoy(parkinglots, normalParkingBoyStrategy);
        Car car = new Car(1);
        parkingBoy.park(car);

        assertThat(parkingBoy.unPark(1), is(car));
    }

    @Test
    public void shouldNotUnParkOneInvalidCarCorrectly() {

        List<Parkinglot> parkinglots = new ArrayList<Parkinglot>();
        parkinglots.add(new Parkinglot(2));
        NormalParkingBoy parkingBoy = new NormalParkingBoy(parkinglots, normalParkingBoyStrategy);
        parkingBoy.park(new Car(1));

        assertThat(parkingBoy.unPark(2), is((Car) null));
    }
}
