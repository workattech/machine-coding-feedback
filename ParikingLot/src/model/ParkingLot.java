package model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final String parkingLotId;
    private final int numberOfFloors;
    private final int numberOfSlotsPerFloor;
    private Floor[] floor;
    private boolean isFull;
    Map<String, Vehicle> parkingDetails;

    public ParkingLot(String parkingLotId, int numberOfFloors, int numberOfSlotsPerFloor) {
        this.parkingLotId = parkingLotId;
        this.numberOfFloors = numberOfFloors;
        this.numberOfSlotsPerFloor = numberOfSlotsPerFloor;
        this.floor = new Floor[numberOfFloors];
        parkingDetails = new HashMap<>();
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public int getNumberOfSlotsPerFloor() {
        return numberOfSlotsPerFloor;
    }

    public Floor[] getFloor() {
        return floor;
    }

    public void setFloor(Floor[] floor) {
        this.floor = floor;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean isFull) {
        this.isFull = isFull;
    }

    public Map<String, Vehicle> getParkingDetails() {
        return parkingDetails;
    }

    public void setParkingDetails(Map<String, Vehicle> parkingDetails) {
        this.parkingDetails = parkingDetails;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "parkingLotId='" + parkingLotId + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                ", numberOfSlotsPerFloor=" + numberOfSlotsPerFloor +
                ", floor=" + Arrays.toString(floor) +
                ", isFull=" + isFull +
                ", parkingDetails=" + parkingDetails +
                '}';
    }
}
