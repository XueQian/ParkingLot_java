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

        NormalParkingBoy normalParkingBoy = new NormalParkingBoy(parkinglots, new NormalParkingBoyStrategy());
        List<NormalParkingBoy> parkingBoys = new ArrayList<>();
        parkingBoys.add(normalParkingBoy);

        ParkingManager parkingManager = new ParkingManager(parkingBoys);

        assertThat(parkingManager.park(new Car(1)), is(0));
    }

}
