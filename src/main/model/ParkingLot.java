package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private final String id;
    private List<ParkingFloor> parkingFloors;

    public ParkingLot(String id,int noOfFloors, int noOfSlotsPerFloor) {
        List<ParkingFloor> parkingFloors = new ArrayList<>();
        for(int i=1;i<=noOfFloors;i++) {
            parkingFloors.add(addFloor(i,noOfSlotsPerFloor));
        }
        this.id = id;
        this.parkingFloors = parkingFloors;
    }

    protected  ParkingFloor addFloor(int floorNo,int noOfSlotsPerFloor) {
        return new ParkingFloor(floorNo,noOfSlotsPerFloor);
    }

    public Slot findParkingSpot(CarType carType) {
        for(ParkingFloor floor:parkingFloors) {
            Slot slot = floor.findParkingSpot(carType);
            if(slot!=null) {
                return slot;
            }
        }
        return null;
    }

    public String getId() {
        return id;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public Slot findSlotFromFloorNoAndSlotNo(int floorNo, int slotNo) {
        for(ParkingFloor floor:parkingFloors) {
            if(floor.getFloorNo() == floorNo) {
                return floor.getSlotFromSlotNo(slotNo);
            }
        }
        return null;
    }

    public void getNoOfFreeSlotForVehicleType(CarType carType,Map<Integer, Integer> noOfFreeSlotForVehicleTypePerFloor) {
        for(ParkingFloor floor:parkingFloors) {
            int noOfFreeSpots = floor.getNoFreeSlotForCarType(carType);
            noOfFreeSlotForVehicleTypePerFloor.put(floor.getFloorNo(),noOfFreeSpots);
        }
    }

    public void getSlotForVehicleType(boolean isParked, CarType carType, Map<Integer, List<Slot>> noOfFreeSlotForVehicleTypePerFloor) {
        for(ParkingFloor floor:parkingFloors) {
            List<Slot> freeSlots = floor.getSlotForCarType(carType,isParked);
            noOfFreeSlotForVehicleTypePerFloor.put(floor.getFloorNo(),freeSlots);
        }
    }


}
