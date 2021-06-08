package Designs.parkinglot.command;

import Designs.parkinglot.model.ParkingLot;
import Designs.parkinglot.model.Vehicle;

import java.util.Optional;

public class UnparkVehicleCommand implements Command {
    @Override
    public void execute(ParkingLot[] parkingLot, String[] tokens) {
        ParkingLot defaultParkingLot = parkingLot[0];
        String ticketId = tokens[1];
        String[] splits = ticketId.split("_");
        int floorNum = Integer.parseInt(splits[1]);
        int slotNum = Integer.parseInt(splits[2]);
        Optional<Vehicle> unparkVehicle = defaultParkingLot.unparkVehicle(floorNum - 1, slotNum - 1);
        if (unparkVehicle.isPresent()) {
            Vehicle vehicle = unparkVehicle.get();
            System.out.println("Unparked vehicle with Registration Number: " + vehicle.getRegistrationNumber() + " and Color: " + vehicle.getColor());
        } else
            System.out.println("Invalid Ticket");
    }
}
