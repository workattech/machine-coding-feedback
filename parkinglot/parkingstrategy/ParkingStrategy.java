package Designs.parkinglot.parkingstrategy;

import Designs.parkinglot.model.ParkingLot;
import Designs.parkinglot.model.Slot;
import Designs.parkinglot.model.VehicleType;

import java.util.Optional;
import java.util.TreeMap;
import java.util.TreeSet;

public interface ParkingStrategy {
    Optional<Slot> findAvailableSlot(VehicleType vehicleType, TreeMap<Integer, TreeSet<Integer>> availableFloorSlotMap, ParkingLot parkingLot);

    void updateAvailableFloorSlotMap(Slot availableSlot, TreeMap<Integer, TreeSet<Integer>> availableFloorSlotMap, Slot.Status status);

    void updateOccupiedFloorSlotMap(Slot availableSlot, TreeMap<Integer, TreeSet<Integer>> occupiedFloorSlotMap, Slot.Status status);
}
