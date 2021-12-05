package com.parkingLot.models.parkingLot;

import com.parkingLot.models.vehicles.Vehicle;

public class ParkingLot {
    String id;
    int numOfFloors;
    int numOfSlots;
    Vehicle[][] parkingLot;

    public ParkingLot(String id, int numOfFloors, int numOfSlots) {
        this.id = id;
        this.numOfFloors = numOfFloors;
        this.numOfSlots = numOfSlots;
        parkingLot = new Vehicle[numOfFloors + 1][numOfSlots + 1];
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getnumOfFloors() {
        return numOfFloors;
    }

    public void setnumOfFloors(int numOfFloors) {
        this.numOfFloors = numOfFloors;
    }

    public int getnumOfSlots() {
        return numOfSlots;
    }

    public void setnumOfSlots(int numOfSlots) {
        this.numOfSlots = numOfSlots;
    }

    public Vehicle[][] getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(Vehicle[][] parkingLot) {
        this.parkingLot = parkingLot;
    }
}
