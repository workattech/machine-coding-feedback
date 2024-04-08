import exception.FloorOccupied;
import exception.InvalidTicketId;
import model.ParkingLot;
import model.Vehicle;
import service.InputService;
import service.ParkingLotService;
import service.ParkingService;

import java.io.IOException;

import static model.Command.CREATE_PARKING_LOT;
import static model.Command.DISPLAY;
import static model.Command.PARK_VEHICLE;
import static model.Command.TERMINAL_COMMAND;
import static model.Command.UNPARK_VEHICLE;
import static model.DisplayType.free_count;
import static model.DisplayType.free_slots;
import static model.DisplayType.occupied_slots;

public class ParkingLotMain {

    public static void main(String[] args) {
        ParkingLotService parkingLotService = new ParkingLotService();
        ParkingService parkingService = new ParkingService();
        InputService inputService = new InputService();
        try {
            String[] queries = inputService.readFromCommandLine().split(" ");
            String command = queries[0];
            ParkingLot parkingLot = null;
            while (!TERMINAL_COMMAND.getCommand().equals(command)) {
                if (CREATE_PARKING_LOT.getCommand().equals(command)) {
                    String parkingLotId = queries[1];
                    int numberOfFloors = Integer.parseInt(queries[2]);
                    int numberOfSlots = Integer.parseInt(queries[3]);
                    parkingLot = parkingLotService.constructParkingLot(parkingLotId, numberOfFloors, numberOfSlots);
                    System.out.println("Created parking lot with " + numberOfFloors + " floors and " + numberOfSlots + " slots per floor");
                }
                if (parkingLot == null) {
                    System.out.println("Parking lot not initialized");
                    throw new RuntimeException();
                }
                if (PARK_VEHICLE.getCommand().equals(command)) {
                    try {
                        System.out.println("Parked vehicle. Ticket ID: " +
                                parkingService.parkVehicle(parkingLot, queries[1], queries[2], queries[3]));
                    } catch (FloorOccupied floorOccupied) {
                        System.out.println(floorOccupied.getMessage());
                    }
                }
                if (UNPARK_VEHICLE.getCommand().equals(command)) {
                    try {
                        Vehicle vehicle = parkingService.unParkVehicle(parkingLot, queries[1]);
                        System.out.println("Unparked vehicle with Registration Number: " + vehicle.getRegistrationNumber() + " and Color: " + vehicle.getColour());
                    } catch (InvalidTicketId invalidTicketId) {
                        System.out.println(invalidTicketId.getMessage());
                    }
                }
                if (DISPLAY.getCommand().equals(command)) {
                    String type = queries[1];
                    if (occupied_slots.getType().equals(type)) {
                        parkingLotService.getOccupiedSlots(parkingLot, queries[2]);
                    }
                    if (free_count.getType().equals(type)) {
                        parkingLotService.getFreeCount(parkingLot, queries[2]);
                    }
                    if (free_slots.getType().equals(type)) {
                        parkingLotService.getFreeSlots(parkingLot, queries[2]);
                    }
                }
                queries = inputService.readFromCommandLine().split(" ");
                command = queries[0];
            }
        } catch (IOException ioException) {
            System.out.println("Error reading from command line");
            throw new RuntimeException(ioException);
        } catch (RuntimeException runtimeException) {
            throw new RuntimeException(runtimeException);
        }
    }
}