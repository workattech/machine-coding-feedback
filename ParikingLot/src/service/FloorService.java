package service;

import model.Floor;
import model.ParkingLot;
import model.Slot;
import model.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static model.VehicleType.BIKE;
import static model.VehicleType.CAR;
import static model.VehicleType.TRUCK;

public class FloorService {
    SlotService slotService = new SlotService();
    public void constructFloor(Floor[] floors, int numberOfFloors, int numbderOfSlotsPerFloor) {
        for (int floorId=0; floorId<numberOfFloors; floorId++) {
            floors[floorId] = new Floor(numbderOfSlotsPerFloor);
            new SlotService().constructSlot(floors[floorId].getSlots(), numbderOfSlotsPerFloor);
            floors[floorId].getNumberOfFreeSlots().put(CAR.getType(), numbderOfSlotsPerFloor - 3);
            floors[floorId].getNumberOfFreeSlots().put(BIKE.getType(), 2);
            floors[floorId].getNumberOfFreeSlots().put(TRUCK.getType(), 1);
        }
    }

    public String getOccupiedSlots(Floor floor, String vehicleType) {
        List<Integer> occupiedSlots = new ArrayList<>();
        for (int slotId=0; slotId< floor.getTotalSlots(); slotId++) {
            Slot slot = floor.getSlots()[slotId];
            if (slot.getVehicleType().equals(vehicleType) && !slot.isAvailable()) {
                occupiedSlots.add(slotId + 1);
            }
        }
        return occupiedSlots.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }

    public int getFreeCount(Floor floor, String vehicleType) {
        return floor.getNumberOfFreeSlots().get(vehicleType);
    }

    public String getFreeSlots(Floor floor, String vehicleType) {
        List<Integer> freeSlots = new ArrayList<>();
        for (int slotId=0; slotId<floor.getTotalSlots(); slotId++) {
            Slot slot = floor.getSlots()[slotId];
            if (slot.getVehicleType().equals(vehicleType) && slot.isAvailable()) {
                freeSlots.add(slotId + 1);
            }
        }
        return freeSlots.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }

    public int getAvailableSlot(Floor floor, String vehicleType) {
        if (floor.isFull()) {
            return -1;
        }

        for (int slotId=0; slotId< floor.getTotalSlots(); slotId++) {
            Slot slot = floor.getSlots()[slotId];
            if (slot.getVehicleType().equals(vehicleType) && slot.isAvailable()) {
                return slotId;
            }
        }

        return -1;
    }

    public String fillSlot(ParkingLot parkingLot, Vehicle vehicle) {
        if (parkingLot.isFull()) return null;

        String vehicleType = vehicle.getType();
        for (int floorId=0; floorId<parkingLot.getNumberOfFloors(); floorId++) {
            Floor floor = parkingLot.getFloor()[floorId];
            int slotId = getAvailableSlot(floor, vehicleType);
            if (slotId != -1) {
                updateUnAvailableSlots(floor, slotId, vehicle.getType());
                return (floorId+1) + "_" + (slotId+1);
            }
        }
        return null;
    }

    public void updateUnAvailableSlots(Floor floor, int slotId, String vehicleType) {
        Map<String, Integer> freeSlots = floor.getNumberOfFreeSlots();
        freeSlots.put(vehicleType, freeSlots.getOrDefault(vehicleType, 0) - 1);
        slotService.updateSlot(floor.getSlots()[slotId], false);
    }

    public void updateAvailableSlots(Floor floor, int slotId, String vehicleType) {
        Map<String, Integer> freeSlots = floor.getNumberOfFreeSlots();
        freeSlots.put(vehicleType, freeSlots.getOrDefault(vehicleType, 0) + 1);
        slotService.updateSlot(floor.getSlots()[slotId], true);
    }
}
