package Designs.parkinglot.command;

import Designs.parkinglot.model.ParkingLot;
import Designs.parkinglot.parkingstrategy.NearestAvailableSlotStrategy;

public class CreateParkingLotCommand implements Command {

    @Override
    public void execute(ParkingLot[] parkingLot, String[] tokens) {
        String parkingLotId = tokens[1];
        Integer noOfFloors = Integer.parseInt(tokens[2]);
        Integer noOfSlotsPerFloor = Integer.parseInt(tokens[3]);
        parkingLot[0] = new ParkingLot(parkingLotId, noOfFloors, noOfSlotsPerFloor, new NearestAvailableSlotStrategy());
        System.out.println("Created parking lot with " + noOfFloors + " floors and " + noOfSlotsPerFloor + " slots per floor");
    }
}
