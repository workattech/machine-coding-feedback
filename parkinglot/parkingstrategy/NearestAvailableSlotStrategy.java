package Designs.parkinglot.parkingstrategy;

import Designs.parkinglot.model.*;

import java.util.*;

public class NearestAvailableSlotStrategy implements ParkingStrategy {
    @Override
    public Optional<Slot> findAvailableSlot(VehicleType vehicleType, TreeMap<Integer, TreeSet<Integer>> availableFloorSlotMap, ParkingLot parkingLot) {
        Map.Entry<Integer, TreeSet<Integer>> parkingFloorSlotEntry = null;
        for (Map.Entry<Integer, TreeSet<Integer>> entry : availableFloorSlotMap.entrySet()) {
            if (entry.getValue().size() > 0) {
                parkingFloorSlotEntry = entry;
                break;
            }
        }
        if (Objects.isNull(parkingFloorSlotEntry)) {
            return Optional.empty();
        }
        Integer floorNum = parkingFloorSlotEntry.getKey();
        Integer slotNum = parkingFloorSlotEntry.getValue().first();
        Floor flr = parkingLot.getFloors().get(floorNum - 1);
        Slot slot = flr.getSlots().get(slotNum - 1);
        return Optional.of(slot);
    }

    @Override
    public void updateAvailableFloorSlotMap(Slot slot, TreeMap<Integer, TreeSet<Integer>> availableFloorSlotMap, Slot.Status status) {
        if (Slot.Status.BOOKED == status) {
            TreeSet<Integer> slots = availableFloorSlotMap.get(slot.getFloorNumber());
            slots.remove(slot.getSlotNumber());
        } else if (Slot.Status.VACATED == status) {
            TreeSet<Integer> slotsSet = availableFloorSlotMap.getOrDefault(slot.getFloorNumber(), new TreeSet<>());
            slotsSet.add(slot.getSlotNumber());
            availableFloorSlotMap.put(slot.getFloorNumber(), slotsSet);
        }
    }

    @Override
    public void updateOccupiedFloorSlotMap(Slot slot, TreeMap<Integer, TreeSet<Integer>> occupiedFloorSlotMap, Slot.Status status) {
        if (Slot.Status.BOOKED == status) {
            TreeSet<Integer> slots = occupiedFloorSlotMap.get(slot.getFloorNumber());
            slots.add(slot.getSlotNumber());
            occupiedFloorSlotMap.put(slot.getFloorNumber(), slots);
        } else if (Slot.Status.VACATED == status) {
            TreeSet<Integer> slots = occupiedFloorSlotMap.get(slot.getFloorNumber());
            slots.remove(slot.getSlotNumber());
        }
    }
}
