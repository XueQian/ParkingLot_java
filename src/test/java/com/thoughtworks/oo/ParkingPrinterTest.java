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
        parkingBoys.add(new NormalParkingBoy(null, null));
        parkingBoys.add(new NormalParkingBoy(null, null));
        ParkingManager parkingManager = new ParkingManager(parkingBoys);

        new ParkingPrinter().print(parkingManager);
        assertThat(outContent.toString(), is("parkingManager:\n" +
                "-parkingBoy0:\n" +
                "-parkingBoy1:\n"));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}
