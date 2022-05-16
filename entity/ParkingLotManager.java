package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ParkingLotManager {

    private final List<ParkingLot> parkingLots;

    private final Map<ParkingSlot, Vehicle> filledSlots;

    public ParkingLotManager(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        this.filledSlots = new HashMap<>();
    }

    ParkingLotManager(List<ParkingLot> parkingLots, Map<ParkingSlot, Vehicle> filledSlots) {
        this.parkingLots = parkingLots;
        this.filledSlots = filledSlots;
    }

    private VehicleType getTypeOfSlot(Integer slotNum) {
        if (slotNum == 1) {
            return VehicleType.TRUCK;
        }
        else if (slotNum>=2 && slotNum <=3) {
            return VehicleType.BIKE;
        }
        else {
            return VehicleType.CAR;
        }
    }

    private Optional<ParkingSlot> getFirstAvailableSlot(VehicleType vehicleType) {
        for (ParkingLot parkingLot: parkingLots) {
            for (int i = 1; i <= parkingLot.numOfFLoors; i++) {
                for (int j = 1; j <= parkingLot.numOfSlotsPerFloor; j++) {
                    if (getTypeOfSlot(j) == vehicleType) {
                        ParkingSlot parkingSlot = new ParkingSlot(parkingLot.parkingLotId, i, j);
                        if(!filledSlots.containsKey(parkingSlot)) {
                            return Optional.of(parkingSlot);
                        }
                    }
                }
            }
        }
        return Optional.empty();
    }

    public void parkVehicle(Vehicle vehicle) {
        Optional<ParkingSlot> parkingSlotOptional = getFirstAvailableSlot(vehicle.type);
        if (parkingSlotOptional.isPresent()) {
            ParkingSlot parkingSlot = parkingSlotOptional.get();
            filledSlots.put(parkingSlot, vehicle);
            Ticket ticket = new Ticket(parkingSlot);
            System.out.printf("Parked Vehicle. Ticket Id: %s%n",
                    ticket.getTicketId());
        } else {
            System.out.println("Parking Lot Full");
        }
    }

    public void unparkVehicle(ParkingSlot parkingSlot) {
        if (filledSlots.containsKey(parkingSlot)) {
            Vehicle vehicle = filledSlots.get(parkingSlot);
            System.out.printf("UnParked Vehicle with Reg Num: %s and Color: %s%n",
                    vehicle.registerationNum,
                    vehicle.color);
            filledSlots.remove(parkingSlot);
        } else {
            System.out.println("Invalid Ticket");
        }
    }

    public void displayFreeCount(VehicleType vehicleType){
        for (ParkingLot parkingLot: parkingLots) {
            for (int i = 1; i <= parkingLot.numOfFLoors; i++) {
                int freeCount = 0;
                for (int j = 1; j <= parkingLot.numOfSlotsPerFloor; j++) {
                    if (getTypeOfSlot(j) == vehicleType) {
                        ParkingSlot parkingSlot = new ParkingSlot(parkingLot.parkingLotId, i, j);
                        if(!filledSlots.containsKey(parkingSlot)) {
                            freeCount++;
                        }
                    }
                }
                System.out.printf("No of Free Slots for %s on Floor %s: %s %n",
                        vehicleType, i ,freeCount);
            }
        }
    }

    public void displayFreeSlots(VehicleType vehicleType) {
        for (ParkingLot parkingLot: parkingLots) {
            for (int i = 1; i <= parkingLot.numOfFLoors; i++) {
                List<Integer> freeSlots = new ArrayList<>();
                for (int j = 1; j <= parkingLot.numOfSlotsPerFloor; j++) {
                    if (getTypeOfSlot(j) == vehicleType) {
                        ParkingSlot parkingSlot = new ParkingSlot(parkingLot.parkingLotId, i, j);
                        if(!filledSlots.containsKey(parkingSlot)) {
                            freeSlots.add(j);
                        }
                    }
                }
                if (!freeSlots.isEmpty()) {
                    System.out.printf("Free Slots for %s on Floor %s %n", vehicleType,
                            freeSlots);
                }
            }
        }
    }

    public void displayOccupiedSlots(VehicleType vehicleType){
        for (ParkingLot parkingLot: parkingLots) {
            for (int i = 1; i <= parkingLot.numOfFLoors; i++) {
                List<Integer> freeSlots = new ArrayList<>();
                for (int j = 1; j <= parkingLot.numOfSlotsPerFloor; j++) {
                    if (getTypeOfSlot(j) == vehicleType) {
                        ParkingSlot parkingSlot = new ParkingSlot(parkingLot.parkingLotId, i, j);
                        if(filledSlots.containsKey(parkingSlot)) {
                            freeSlots.add(j);
                        }
                    }
                }
                if (!freeSlots.isEmpty()) {
                    System.out.printf("Occupied Slots for %s on Floor %s %n", vehicleType,
                            freeSlots);
                }
            }
        }
    }
}

