package com.thoughtworks.oo;

import com.thoughtworks.oo.strategy.NormalParkingBoyStrategy;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SuperParkingManagerTest {

    @Test
    public void shouldManageParkingBoyCorrectly() {

        Parkinglot parkingLot = new Parkinglot(3);
        List<Parkinglot> parkinglots = new ArrayList<>();
        parkinglots.add(parkingLot);

        NormalParkingBoy normalParkingBoy = new NormalParkingBoy(parkinglots, new NormalParkingBoyStrategy());
        List<NormalParkingBoy> parkingBoys = new ArrayList<>();
        parkingBoys.add(normalParkingBoy);

        ParkingManager parkingManager = new ParkingManager(parkingBoys);
        List<ParkingManager> parkingManagers = new ArrayList<>();
        parkingManagers.add(parkingManager);

        SuperParkingManager superParkingManager = new SuperParkingManager(parkingManagers);

        assertThat(superParkingManager.park(new Car(1)), is(0));
    }
}
