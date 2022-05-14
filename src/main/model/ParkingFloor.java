package model;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private final int floorNo;
    private List<Slot> slots;
    private final int NO_OF_TRUCK_SLOTS  = 1;
    private final int NO_OF_BIKE_SLOTS   = 3;

    public ParkingFloor(int floorNo, int noOfSlots) {
        List<Slot> slots = new ArrayList<>();
        for(int i=1;i<=noOfSlots;i++) {
            if(i<=NO_OF_TRUCK_SLOTS) {
                slots.add(addSlot(floorNo,i,CarType.TRUCK));
            } else if(i<=NO_OF_BIKE_SLOTS) {
                slots.add(addSlot(floorNo,i,CarType.BIKE));
            } else {
                slots.add(addSlot(floorNo,i,CarType.CAR));
            }
        }
        this.floorNo = floorNo;
        this.slots = slots;
    }

    protected Slot addSlot(int floorNo,int slotNo,CarType carType){
        return new Slot(floorNo, slotNo,carType,false,null);
    }

    public Slot findParkingSpot(CarType carType) {
        for(Slot slot:slots) {
            if(slot.getCarType() == carType && slot.isCarParked() == false) {
                return slot;
            }
        }
        return null;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public Slot getSlotFromSlotNo(int slotNo) {
        for(Slot slot:slots) {
            if(slot.getSlotNo() == slotNo) {
                return slot;
            }
        }
        return null;
    }

    public int getNoFreeSlotForCarType(CarType carType) {
        int noOfFreeSpots = 0;
        for(Slot slot:slots) {
            if(slot.getCarType() == carType && slot.isCarParked() == false)
                noOfFreeSpots++;
        }
        return  noOfFreeSpots;
    }

    public List<Slot> getSlotForCarType(CarType carType,boolean isParked) {
        List<Slot> slotsList = new ArrayList<>();
        for(Slot slot:slots) {
            if(slot.isCarParked() == isParked && slot.getCarType() == carType) slotsList.add(slot);
        }
        return slotsList;
    }
}
