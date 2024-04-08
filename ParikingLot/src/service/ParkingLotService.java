package service;

import model.Floor;
import model.ParkingLot;

public class ParkingLotService {
    FloorService floorService = new FloorService();
    public ParkingLot constructParkingLot(String parkingLotId, int numberOfFloors, int numberOfSlotsPerFloor) {
        ParkingLot parkingLot = new ParkingLot(parkingLotId, numberOfFloors, numberOfSlotsPerFloor);
        floorService.constructFloor(parkingLot.getFloor(), numberOfFloors, numberOfSlotsPerFloor);
        return parkingLot;
    }

    public void getOccupiedSlots(ParkingLot parkingLot, String vehicleType) {
        Floor[] floors = parkingLot.getFloor();
        for (int floorId=0; floorId<floors.length; floorId++) {
            System.out.println("Occupied slots for " + vehicleType + " on Floor " + (floorId+1) + " : " +
            floorService.getOccupiedSlots(floors[floorId], vehicleType));
        }
    }

    public void getFreeCount(ParkingLot parkingLot, String vehicleType) {
        Floor[] floors = parkingLot.getFloor();
        for (int floorId=0; floorId<floors.length; floorId++) {
            System.out.println("No. of free slots for " + vehicleType + " on Floor " + (floorId+1) + " : " +
                    floorService.getFreeCount(floors[floorId], vehicleType));
        }
    }

    public void getFreeSlots(ParkingLot parkingLot, String vehicleType) {
        Floor[] floors = parkingLot.getFloor();
        for (int floorId=0; floorId<floors.length; floorId++) {
            System.out.println("Free slots for " + vehicleType + " on Floor " + (floorId+1) + " : " +
                    floorService.getFreeSlots(floors[floorId], vehicleType));
        }
    }
}
