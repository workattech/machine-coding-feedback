package Designs.parkinglot.command;

import Designs.parkinglot.model.ParkingLot;

public interface Command {
    void execute(ParkingLot[] parkingLot, String[] tokens);
}
