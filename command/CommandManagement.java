package command;

import java.util.Objects;

import entity.ParkingLot;
import entity.ParkingLotManager;
import entity.ParkingSlot;
import entity.Vehicle;
import entity.VehicleType;

public class CommandManagement {

    public CommandManagement() {
    }

    public Integer getCommandType(String command) {
        String[] splited = command.split("\\s+");
        if (Objects.equals(splited[0], "create_parking_lot")) {
            return 1;
        } else if (Objects.equals(splited[0], "park_vehicle")) {
            return 2;
        } else if (Objects.equals(splited[0], "unpark_vehicle")) {
            return 3;
        } else if(Objects.equals(splited[0], "display")) {
            return 4;
        }
        else return 5;
    }

    public ParkingLot createParkingLot(String command) {
        String[] splited = command.split("\\s+");
        return new ParkingLot(splited[1], Integer.valueOf(splited[2]), Integer.valueOf(splited[3]));
    }

    public void parkVehicle(String command, ParkingLotManager parkingLotManager) {
        String[] splited = command.split("\\s+");
        Vehicle vehicle = new Vehicle(splited[3], splited[2], VehicleType.valueOf(splited[1]));
        parkingLotManager.parkVehicle(vehicle);
    }

    public void unparkVehicle(String command, ParkingLotManager parkingLotManager) {
        String[] splited = command.split("\\s+");
        String[] splited2 = splited[1].split("_");
        ParkingSlot parkingSlot = new ParkingSlot(splited2[0], Integer.valueOf(splited2[1]),
                Integer.valueOf(splited2[2]));
        parkingLotManager.unparkVehicle(parkingSlot);
    }

    public void display(String command, ParkingLotManager parkingLotManager) {
        String[] splited = command.split("\\s+");
        if (Objects.equals(splited[1], "free_count")){
            parkingLotManager.displayFreeCount(VehicleType.valueOf(splited[2]));
        } else if(Objects.equals(splited[1], "free_slots")) {
            parkingLotManager.displayFreeSlots(VehicleType.valueOf(splited[2]));
        } else if(Objects.equals(splited[1], "occupied_slots")) {
            parkingLotManager.displayOccupiedSlots(VehicleType.valueOf(splited[2]));
        } else {
            System.out.println("Invalid Command");
        }
    }


}
