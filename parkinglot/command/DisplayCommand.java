package Designs.parkinglot.command;

import Designs.parkinglot.model.ParkingLot;
import Designs.parkinglot.model.VehicleType;

public class DisplayCommand implements Command {
    @Override
    public void execute(ParkingLot[] parkingLot, String[] tokens) {
        ParkingLot defaultParkingLot = parkingLot[0];
        DisplayType displayType = DisplayType.valueOf(tokens[1].toUpperCase());
        VehicleType vehicleType = VehicleType.valueOf(tokens[2].toUpperCase());
        if (displayType == DisplayType.FREE_COUNT)
            defaultParkingLot.displayFreeCountFor(vehicleType);
        else if (displayType == DisplayType.FREE_SLOTS)
            defaultParkingLot.displayFreeSlotsFor(vehicleType);
        else if (displayType == DisplayType.OCCUPIED_SLOTS)
            defaultParkingLot.displayOccupiedSlotsFor(vehicleType);
    }

    public enum DisplayType {
        FREE_COUNT, FREE_SLOTS, OCCUPIED_SLOTS
    }
}
