package com.thoughtworks.oo.strategy;

import com.thoughtworks.oo.Parkinglot;

import java.util.List;

public interface ParkStrategy {
    Parkinglot getParkingLot(List<Parkinglot> parkinglots);
}
