package parking_lot;

import java.util.Map;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class ParkingFloor {
    private int noOfSlots;
    private ParkingLot parkingLot;
    private ParkingSlot[] parkingSlots;
    private int id;
    private Map<VehicleType, SortedSet<Integer>> availableSlots = new ConcurrentHashMap<>();
    private Map<VehicleType, SortedSet<Integer>> occupiedSlots = new ConcurrentHashMap<>();

    public ParkingFloor(int noOfSlotsPerFloor, ParkingLot parkingLot, int floorId) {
        this.noOfSlots = noOfSlotsPerFloor;
        this.parkingLot = parkingLot;
        parkingSlots = new ParkingSlot[noOfSlots + 1];
        this.id = floorId;
        for (VehicleType vehicleType : VehicleType.values()) {
            availableSlots.put(vehicleType, new ConcurrentSkipListSet<Integer>());
            occupiedSlots.put(vehicleType, new ConcurrentSkipListSet<Integer>());
        }
        parkingSlots[1] = new ParkingSlot(parkingLot, this, VehicleType.TRUCK, 1);
        availableSlots.get(VehicleType.TRUCK).add(1);
        if (noOfSlotsPerFloor > 2) {
            parkingSlots[2] = new ParkingSlot(parkingLot, this, VehicleType.BIKE, 2);
            availableSlots.get(VehicleType.BIKE).add(2);
            if (noOfSlotsPerFloor > 3) {
                parkingSlots[3] = new ParkingSlot(parkingLot, this, VehicleType.BIKE, 3);
                availableSlots.get(VehicleType.BIKE).add(3);
            }
        }
        for (int i = 4; i <= noOfSlotsPerFloor; ++i) {
            parkingSlots[i] = new ParkingSlot(parkingLot, this, VehicleType.CAR, i);
            availableSlots.get(VehicleType.CAR).add(i);
        }
    }

    public int getNoOfSlots() {
        return noOfSlots;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public ParkingSlot getParkingSlot(int slotId) {
        return parkingSlots[slotId];
    }

    public int getId() {
        return id;
    }

    public boolean hasFreeSlot(VehicleType type) {
        return !availableSlots.get(type).isEmpty();
    }

    public synchronized ParkingSlot parkVehicle(Vehicle vehicle) throws IllegalAccessException {
        if (!hasFreeSlot(vehicle.getType())) {
            return null;
        }
        int slotId = availableSlots.get(vehicle.getType()).first();
        parkingSlots[slotId].parkVehicle(vehicle);
        availableSlots.get(vehicle.getType()).remove(slotId);
        occupiedSlots.get(vehicle.getType()).add(slotId);
        return parkingSlots[slotId];
    }

    public synchronized Vehicle unParkVehicle(int slotId) throws IllegalAccessException {
        Vehicle vehicle = parkingSlots[slotId].unParkVehicle();
        availableSlots.get(vehicle.getType()).add(slotId);
        occupiedSlots.get(vehicle.getType()).remove(slotId);
        return vehicle;
    }

    public void displayFreeCount(VehicleType vehicleType) {
        System.out.println(String.format("No. of free slots for %s on Floor %d: %d", vehicleType.name(), id,
                availableSlots.get(vehicleType).size()));
    }

    public void displayFreeSlots(VehicleType vehicleType) {
        System.out.print(String.format("Free slots for %s on Floor %d: ", vehicleType.name(), id));
        for (Integer slotId : availableSlots.get(vehicleType)) {
            System.out.print(slotId + " ");
        }
        System.out.println("");
    }

    public void displayOccupiedSlots(VehicleType vehicleType) {
        System.out.print(String.format("Occupied slots for %s on Floor %d: ", vehicleType.name(), id));
        for (Integer slotId : occupiedSlots.get(vehicleType)) {
            System.out.print(slotId + " ");
        }
        System.out.println("");
    }

}
