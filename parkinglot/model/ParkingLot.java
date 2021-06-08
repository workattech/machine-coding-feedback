package Designs.parkinglot.model;

import Designs.parkinglot.parkingstrategy.ParkingStrategy;

import java.util.*;

public class ParkingLot {
    private final String parkingLotId;
    public static final Integer RESERVED_SLOT_FOR_TRUCK = 1;
    public static final List<Integer> RESERVED_SLOT_FOR_BIKE = List.of(2, 3);
    private final Integer noOfFloors;
    private final Integer noOfSlotsPerFloor;
    private final List<Floor> floors = new ArrayList<>();
    // Used strategy pattern here
    private final ParkingStrategy parkingStrategy;
    // Maintaining reference of available floor-slots by vehicle type to get next available slot faster and for display operations
    private final Map<VehicleType, TreeMap<Integer, TreeSet<Integer>>> availableFloorSlotMapByVehicleType = new HashMap<>();
    // Maintaining reference of occupied floor-slots by vehicle type for display operations
    private final Map<VehicleType, TreeMap<Integer, TreeSet<Integer>>> occupiedFloorSlotMapByVehicleType = new HashMap<>();

    public ParkingLot(String parkingLotId, Integer noOfFloors, Integer noOfSlotsPerFloor, ParkingStrategy parkingStrategy) {
        this.parkingLotId = parkingLotId;
        this.parkingStrategy = parkingStrategy;
        this.noOfFloors = noOfFloors;
        this.noOfSlotsPerFloor = noOfSlotsPerFloor;
        initialiseParkingLot(parkingLotId, noOfFloors, noOfSlotsPerFloor);
    }

    private void initialiseParkingLot(String parkingLotId, Integer noOfFloors, Integer noOfSlotsPerFloor) {
        for (int floorNum = 1; floorNum <= noOfFloors; floorNum++) {
            List<Slot> slots = new ArrayList<>();
            for (int slotNum = 1; slotNum <= noOfSlotsPerFloor; slotNum++) {
                Slot slot = new Slot(slotNum, floorNum, parkingLotId, null, Slot.Status.VACATED);
                if (slotNum == RESERVED_SLOT_FOR_TRUCK) {
                    slot.setVehicleType(VehicleType.TRUCK);
                    TreeMap<Integer, TreeSet<Integer>> availableSlotsMapOrDefault = availableFloorSlotMapByVehicleType.getOrDefault(VehicleType.TRUCK, new TreeMap<>());
                    TreeSet<Integer> slotsList = availableSlotsMapOrDefault.getOrDefault(floorNum, new TreeSet<>());
                    slotsList.add(slotNum);
                    availableSlotsMapOrDefault.put(floorNum, slotsList);
                    availableFloorSlotMapByVehicleType.put(VehicleType.TRUCK, availableSlotsMapOrDefault);

                    TreeMap<Integer, TreeSet<Integer>> occupiedSlotsMapOrDefault = occupiedFloorSlotMapByVehicleType.getOrDefault(VehicleType.TRUCK, new TreeMap<>());
                    occupiedSlotsMapOrDefault.put(floorNum, new TreeSet<>());
                    occupiedFloorSlotMapByVehicleType.put(VehicleType.TRUCK, occupiedSlotsMapOrDefault);
                } else if (RESERVED_SLOT_FOR_BIKE.contains(slotNum)) {
                    slot.setVehicleType(VehicleType.BIKE);
                    TreeMap<Integer, TreeSet<Integer>> availableSlotsMapOrDefault = availableFloorSlotMapByVehicleType.getOrDefault(VehicleType.BIKE, new TreeMap<>());
                    TreeSet<Integer> slotsList = availableSlotsMapOrDefault.getOrDefault(floorNum, new TreeSet<>());
                    slotsList.add(slotNum);
                    availableSlotsMapOrDefault.put(floorNum, slotsList);
                    availableFloorSlotMapByVehicleType.put(VehicleType.BIKE, availableSlotsMapOrDefault);

                    TreeMap<Integer, TreeSet<Integer>> occupiedSlotsMapOrDefault = occupiedFloorSlotMapByVehicleType.getOrDefault(VehicleType.BIKE, new TreeMap<>());
                    occupiedSlotsMapOrDefault.put(floorNum, new TreeSet<>());
                    occupiedFloorSlotMapByVehicleType.put(VehicleType.BIKE, occupiedSlotsMapOrDefault);
                } else {
                    slot.setVehicleType(VehicleType.CAR);
                    TreeMap<Integer, TreeSet<Integer>> availableSlotsMapOrDefault = availableFloorSlotMapByVehicleType.getOrDefault(VehicleType.CAR, new TreeMap<>());
                    TreeSet<Integer> slotsList = availableSlotsMapOrDefault.getOrDefault(floorNum, new TreeSet<>());
                    slotsList.add(slotNum);
                    availableSlotsMapOrDefault.put(floorNum, slotsList);
                    availableFloorSlotMapByVehicleType.put(VehicleType.CAR, availableSlotsMapOrDefault);

                    TreeMap<Integer, TreeSet<Integer>> occupiedSlotsMapOrDefault = occupiedFloorSlotMapByVehicleType.getOrDefault(VehicleType.CAR, new TreeMap<>());
                    occupiedSlotsMapOrDefault.put(floorNum, new TreeSet<>());
                    occupiedFloorSlotMapByVehicleType.put(VehicleType.CAR, occupiedSlotsMapOrDefault);
                }

                slots.add(slot);
            }

            floors.add(new Floor(slots));
        }
    }

    public synchronized Optional<Slot> parkVehicle(VehicleType vehicleType, String registrationNumber, String vehicleColor) {
        TreeMap<Integer, TreeSet<Integer>> availableFloorSlotMap = availableFloorSlotMapByVehicleType.get(vehicleType);
        TreeMap<Integer, TreeSet<Integer>> occupiedFloorSlotMap = occupiedFloorSlotMapByVehicleType.get(vehicleType);
        Optional<Slot> optionalSlot = parkingStrategy.findAvailableSlot(vehicleType, availableFloorSlotMap, this);
        if (optionalSlot.isEmpty()) return Optional.empty();

        Slot availableSlot = optionalSlot.get();
        Vehicle vehicle = new Vehicle(vehicleType, registrationNumber, vehicleColor);
        availableSlot.book(vehicle);
        parkingStrategy.updateAvailableFloorSlotMap(availableSlot, availableFloorSlotMap, Slot.Status.BOOKED);
        parkingStrategy.updateOccupiedFloorSlotMap(availableSlot, occupiedFloorSlotMap, Slot.Status.BOOKED);

        return Optional.of(availableSlot);
    }

    public synchronized Optional<Vehicle> unparkVehicle(Integer floorNum, Integer slotNum) {
        if (floorNum >= noOfFloors || slotNum >= noOfSlotsPerFloor) {
            return Optional.empty();
        }
        Floor floor = floors.get(floorNum);
        Slot slotToVacate = null;
        if (floor != null) {
            List<Slot> slots = floor.getSlots();
            slotToVacate = slots.get(slotNum);
        }
        if (slotToVacate == null) return Optional.empty();

        Vehicle vehicle = slotToVacate.getVehicle();
        if (vehicle == null) return Optional.empty();
        TreeMap<Integer, TreeSet<Integer>> availableFloorSlotMap = availableFloorSlotMapByVehicleType.get(vehicle.getVehicleType());
        TreeMap<Integer, TreeSet<Integer>> occupiedFloorSlotMap = occupiedFloorSlotMapByVehicleType.get(vehicle.getVehicleType());

        slotToVacate.vacate();
        parkingStrategy.updateAvailableFloorSlotMap(slotToVacate, availableFloorSlotMap, Slot.Status.VACATED);
        parkingStrategy.updateOccupiedFloorSlotMap(slotToVacate, occupiedFloorSlotMap, Slot.Status.VACATED);

        return Optional.of(vehicle);
    }

    public void displayFreeCountFor(VehicleType vehicleType) {
        TreeMap<Integer, TreeSet<Integer>> availableFloorSlotMap = availableFloorSlotMapByVehicleType.get(vehicleType);
        for (Map.Entry<Integer, TreeSet<Integer>> entry : availableFloorSlotMap.entrySet()) {
            System.out.println("No. of free slots for " + vehicleType + " on Floor " + entry.getKey() + " : " + entry.getValue().size());
        }
    }

    public void displayFreeSlotsFor(VehicleType vehicleType) {
        TreeMap<Integer, TreeSet<Integer>> availableFloorSlotMap = availableFloorSlotMapByVehicleType.get(vehicleType);
        for (Map.Entry<Integer, TreeSet<Integer>> entry : availableFloorSlotMap.entrySet()) {
            System.out.println("Free slots for " + vehicleType + " on Floor " + entry.getKey() + " : " + entry.getValue());
        }
    }

    public void displayOccupiedSlotsFor(VehicleType vehicleType) {
        TreeMap<Integer, TreeSet<Integer>> occupiedFloorSlotMap = occupiedFloorSlotMapByVehicleType.getOrDefault(vehicleType, new TreeMap<>());
        for (Map.Entry<Integer, TreeSet<Integer>> entry : occupiedFloorSlotMap.entrySet()) {
            System.out.println("Occupied slots for " + vehicleType + " on Floor " + entry.getKey() + " : " + entry.getValue());
        }
    }

    public List<Floor> getFloors() {
        return floors;
    }
}
