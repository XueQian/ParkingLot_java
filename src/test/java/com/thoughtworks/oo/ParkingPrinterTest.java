package com.thoughtworks.oo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ParkingPrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldPrintParkingManagerAndParkingBoyStringCorrectly() {

        ArrayList<Parkable> parkingBoys = new ArrayList<>();
        parkingBoys.add(new NormalParkingBoy(new ArrayList<>(), null));
        parkingBoys.add(new NormalParkingBoy(new ArrayList<>(), null));
        ParkingManager parkingManager = new ParkingManager(parkingBoys);

        ParkingPrinter.print(parkingManager);
        assertThat(outContent.toString(), is("parkingManager:\n" +
                "-parkingBoy0:\n" +
                "-parkingBoy1:\n"));
    }

    @Test
    public void shouldPrintParkingManagerAndParkingBoyAndParkingLotStringCorrectly() {

        ArrayList<Parkinglot> parkinglots1 = new ArrayList<>();
        Parkinglot parkinglot1 = new Parkinglot(1);
        Parkinglot parkinglot2 = new Parkinglot(1);
        parkinglots1.add(parkinglot1);
        parkinglots1.add(parkinglot2);

        ArrayList<Parkinglot> parkinglots2 = new ArrayList<>();
        Parkinglot parkinglot3 = new Parkinglot(1);
        parkinglots2.add(parkinglot3);

        ArrayList<Parkable> parkingBoys = new ArrayList<>();
        parkingBoys.add(new NormalParkingBoy(parkinglots1, null));
        parkingBoys.add(new NormalParkingBoy(parkinglots2, null));
        ParkingManager parkingManager = new ParkingManager(parkingBoys);

        ParkingPrinter.print(parkingManager);

        assertThat(outContent.toString(), is("parkingManager:\n" +
                "-parkingBoy0:\n" +
                "--parkinglot0:\n" +
                "--parkinglot1:\n" +
                "-parkingBoy1:\n" +
                "--parkinglot0:\n"
        ));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}
