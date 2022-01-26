package domain;

import java.util.List;
import java.util.Map;

public class ParkingLotFloor {
    private Integer floorNo;
    // List containing info about each parking slot in a floor
    // False value means slot is already occupied.
    private List<Boolean> parkingSlots;
    private Map<VehicleTypeEnum, ParkingLotFloorPositions> vehiclePositionMap;
    // 1st slot is for truck
    // 2nd and 3rd slot is for bikes
    // rest is for cars


    public ParkingLotFloor(Integer floorNo, List<Boolean> parkingSlots) {
        this.floorNo = floorNo;
        this.parkingSlots = parkingSlots;
    }

    public Integer getFloorNo() {
        return floorNo;
    }

    public List<Boolean> getParkingSlots() {
        return parkingSlots;
    }
}
