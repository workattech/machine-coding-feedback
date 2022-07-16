package Designs.parkinglot.command;

import Designs.parkinglot.model.ParkingLot;
import Designs.parkinglot.model.Slot;
import Designs.parkinglot.model.VehicleType;

import java.util.Optional;

public class ParkVehicleCommand implements Command {
    @Override
    public void execute(ParkingLot[] parkingLot, String[] tokens) {
        ParkingLot defaultParkingLot = parkingLot[0];
        String registrationNumber = tokens[2];
        String vehicleColor = tokens[3];
        Optional<Slot> parkVehicle = defaultParkingLot.parkVehicle(VehicleType.valueOf(tokens[1].toUpperCase()), registrationNumber, vehicleColor);
        if (parkVehicle.isPresent()) {
            Slot slot = parkVehicle.get();
            System.out.println("Parked vehicle. Ticket ID: " + slot.getParkingLotId() + "_" + slot.getFloorNumber() + "_" + slot.getSlotNumber());
        } else
            System.out.println("Parking Lot Full");
    }
}
