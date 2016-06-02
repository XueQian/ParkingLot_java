package com.thoughtworks.oo;

import com.thoughtworks.oo.strategy.NormalParkingBoyStrategy;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class ParkingManagerTest {

    @Test
    public void shouldManageParkingBoyCorrectly() {
        Parkinglot parkingLot = new Parkinglot(1);
        List<Parkinglot> parkinglots = new ArrayList<>();
        parkinglots.add(parkingLot);

        Parkable normalParkingBoy = new NormalParkingBoy(parkinglots, new NormalParkingBoyStrategy());
        List<Parkable> parkingBoys = new ArrayList<>();
        parkingBoys.add(normalParkingBoy);

        Parkable parkable = new ParkingManager(parkingBoys);

        assertThat(parkable.park(new Car(1)), is(0));
    }

    @Test
    public void shouldManageParkingManagerCorrectly() {

        Parkinglot parkingLot = new Parkinglot(3);
        List<Parkinglot> parkinglots = new ArrayList<>();
        parkinglots.add(parkingLot);

        Parkable normalParkingBoy = new NormalParkingBoy(parkinglots, new NormalParkingBoyStrategy());
        List<Parkable> parkingBoys = new ArrayList<>();
        parkingBoys.add(normalParkingBoy);

        Parkable parkable = new ParkingManager(parkingBoys);
        List<Parkable> parkables = new ArrayList<>();
        parkables.add(parkable);

        Parkable superParkingManager = new ParkingManager(parkables);

        assertThat(superParkingManager.park(new Car(1)), is(0));
    }
}
