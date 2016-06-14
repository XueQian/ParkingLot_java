package com.thoughtworks.oo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(JUnit4.class)
public class ParkingPrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldPrintParkingManagerAndParkingBoyStringCorrectly() {

        ArrayList<Parkable> parkingBoys = new ArrayList<>();
        parkingBoys.add(new ParkingBoy(new ArrayList<>(), null));
        parkingBoys.add(new ParkingBoy(new ArrayList<>(), null));
        ParkingManager parkingManager = new ParkingManager(parkingBoys);

        parkingManager.print("");
        assertThat(outContent.toString(), is(
                "parkingManager:\n" +
                        "-parkingBoy0:\n" +
                        "-parkingBoy1:\n"));
    }

    @Test
    public void shouldPrintParkingManagerAndParkingBoyAndParkingLotAndCountStringCorrectly() {

        ArrayList<Parkinglot> parkinglots1 = new ArrayList<>();
        Parkinglot parkinglot1 = new Parkinglot(3);
        parkinglot1.park(new Car(1));
        Parkinglot parkinglot2 = new Parkinglot(2);
        parkinglots1.add(parkinglot1);
        parkinglots1.add(parkinglot2);

        ArrayList<Parkinglot> parkinglots2 = new ArrayList<>();
        Parkinglot parkinglot3 = new Parkinglot(4);
        parkinglot3.park(new Car(2));
        parkinglot3.park(new Car(3));
        parkinglots2.add(parkinglot3);

        ArrayList<Parkable> parkingBoys = new ArrayList<>();
        parkingBoys.add(new ParkingBoy(parkinglots1, null));
        parkingBoys.add(new ParkingBoy(parkinglots2, null));
        ParkingManager parkingManager = new ParkingManager(parkingBoys);

        parkingManager.print("");

        assertThat(outContent.toString(), is(
                "parkingManager:\n" +
                        "-parkingBoy0:\n" +
                        "--parkinglot0(2/3):\n" +
                        "--parkinglot1(2/2):\n" +
                        "-parkingBoy1:\n" +
                        "--parkinglot0(2/4):\n"
        ));
    }

    @Test
    public void shouldPrintSuperParkingManagerAndParkingManagerAndParkingBoyAndParkingLotAndCountStringCorrectly() {

        ArrayList<Parkinglot> parkinglots1 = new ArrayList<>();
        Parkinglot parkinglot1 = new Parkinglot(3);
        parkinglot1.park(new Car(1));
        Parkinglot parkinglot2 = new Parkinglot(2);
        parkinglots1.add(parkinglot1);
        parkinglots1.add(parkinglot2);

        ArrayList<Parkinglot> parkinglots2 = new ArrayList<>();
        Parkinglot parkinglot3 = new Parkinglot(4);
        parkinglot3.park(new Car(2));
        parkinglot3.park(new Car(3));
        parkinglots2.add(parkinglot3);

        ArrayList<Parkable> parkingBoys = new ArrayList<>();
        parkingBoys.add(new ParkingBoy(parkinglots1, null));
        parkingBoys.add(new ParkingBoy(parkinglots2, null));

        ArrayList<Parkable> parkingManagers = new ArrayList<>();
        ParkingManager parkingManager = new ParkingManager(parkingBoys);
        ParkingManager parkingManager1 = new ParkingManager(new ArrayList<>());
        parkingManagers.add(parkingManager);
        parkingManagers.add(parkingManager1);

        ParkingManager superParkingManager = new ParkingManager(parkingManagers);

        superParkingManager.print("");

        assertThat(outContent.toString(), is(
                "parkingManager:\n" +
                        "-parkingManager:\n" +
                        "--parkingBoy0:\n" +
                        "---parkinglot0(2/3):\n" +
                        "---parkinglot1(2/2):\n" +
                        "--parkingBoy1:\n" +
                        "---parkinglot0(2/4):\n" +
                        "-parkingManager:\n"
        ));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}
