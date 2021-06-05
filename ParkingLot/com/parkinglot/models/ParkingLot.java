package com.parkinglot.models;

import java.util.List;

public class ParkingLot {
    private String parkingId;
    private int numberOfFloors;
    public ParkingLot(String id) {
        this.parkingId = id;
    }

    public ParkingLot(String id, int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
        this.parkingId = id;
    }
    public String getId() {
        return parkingId;
    }


}
