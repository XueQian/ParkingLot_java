package com.thoughtworks.oo;

import com.thoughtworks.oo.strategy.ParkStrategy;
import com.thoughtworks.oo.strategy.SmartParkingBoyStrategy;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SmartParkingBoyTest {

    private ParkStrategy smartParkingBoyStrategy;

    @Before
    public void setUp() {
        smartParkingBoyStrategy = new SmartParkingBoyStrategy();
    }

    @Test
    public void shouldParkOneCarCorrectly() {

        List<Parkinglot> parkinglots = new ArrayList<Parkinglot>();
        parkinglots.add(new Parkinglot(2));
        NormalParkingBoy smartParkingBoy = new NormalParkingBoy(parkinglots, smartParkingBoyStrategy);

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
        NormalParkingBoy smartParkingBoy = new NormalParkingBoy(parkinglots, smartParkingBoyStrategy);

        assertThat(smartParkingBoy.park(new Car(2)), is(1));
    }

    @Test
    public void shouldNotParkCarWhenParkingLotIsFull() {

        List<Parkinglot> parkinglots = new ArrayList<Parkinglot>();
        parkinglots.add(new Parkinglot(0));
        NormalParkingBoy smartParkingBoy = new NormalParkingBoy(parkinglots, smartParkingBoyStrategy);

        assertThat(smartParkingBoy.park(new Car(1)), is(-1));
    }
}
