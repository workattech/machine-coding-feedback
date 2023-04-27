package model;

import lombok.Data;
import utility.VehicleType;

import java.util.ArrayList;
import java.util.List;

@Data
public class Floor {
    private String parkingLotId;
    private int floorNo;
    private List<ParkingSlot> parkingSlots;

    public Floor(String parkingLotId, int floorNo, int noOfSlotsPerFloor) {
        this.parkingLotId = parkingLotId;
        this.floorNo = floorNo;
        this.parkingSlots = addSlots(noOfSlotsPerFloor);
    }

    public static List<ParkingSlot> addSlots(int noOfSlotsPerFloor) {
        List<ParkingSlot> parkingSlots = new ArrayList<>();
        for(int i =1;i<=noOfSlotsPerFloor;i++) {
            ParkingSlot slot = new ParkingSlot();
            slot.setVehicleType(VehicleType.CAR);
            if(i==1) {
                slot.setVehicleType(VehicleType.TRUCK);
            } else if( i>1 && i<=3) {
                slot.setVehicleType(VehicleType.BIKE);
            }
            slot.setSlotId(i);
            slot.setOccupied(false);
            slot.setParkedVehicle(null);
            parkingSlots.add(slot);
        }
        return parkingSlots;
    }
}
