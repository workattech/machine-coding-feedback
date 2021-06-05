package com.parkinglot.models;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private int floorNumber;
    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
    }
    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
}
