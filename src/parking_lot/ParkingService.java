package parking_lot;

import java.io.File;
import java.security.InvalidParameterException;
import java.util.Scanner;

public class ParkingService {
    ParkingLot parkingLot;

    public void run() {
        try (Scanner scan = new Scanner(
                new File("/Users/vedangkarwa/machine-coding-feedback/src/parking_lot/Input.txt"))) {
            while (scan.hasNextLine()) {
                String[] input = scan.nextLine().split(" ");
                if (input[0].equals("create_parking_lot")) {
                    if (input.length != 4) {
                        throw new InvalidParameterException("create_parking_lot should have 4 parameters!");
                    }
                    String parkingLotId = input[1];
                    int noOfFloors = Integer.parseInt(input[2]);
                    int noOfSlotsPerFloor = Integer.parseInt(input[3]);
                    parkingLot = new ParkingLot(parkingLotId, noOfFloors, noOfSlotsPerFloor);
                    System.out.println(String.format("Created parking lot with %d floors and %d slots per floor",
                            noOfFloors, noOfSlotsPerFloor));
                } else if (input[0].equals("park_vehicle")) {
                    if (input.length != 4) {
                        throw new InvalidParameterException("park_vehicle should have 4 parameters!");
                    }
                    String vehicleType = input[1];
                    String registrationNumber = input[2];
                    String color = input[3];
                    System.out.println(parkVehicle(vehicleType, registrationNumber, color));
                } else if (input[0].equals("unpark_vehicle")) {
                    if (input.length != 2) {
                        throw new InvalidParameterException("unpark_vehicle should have 2 parameters!");
                    }
                    String tickedId = input[1];
                    System.out.println(unParkVehicle(tickedId));
                } else if (input[0].equals("display")) {
                    if (input.length != 3) {
                        throw new InvalidParameterException("display should have 3 parameters!");
                    }
                    String displayType = input[1];
                    String vehicleType = input[2];
                    display(displayType, vehicleType);
                } else if (input[0].equals("exit")) {
                    break;
                } else {
                    throw new InvalidParameterException("This command is not supported!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String unParkVehicle(String tickedId) throws IllegalAccessException {
        String[] ticketParsed = tickedId.split("_");
        int floorId = Integer.parseInt(ticketParsed[1]);
        int slotId = Integer.parseInt(ticketParsed[2]);
        Vehicle vehicle = parkingLot.unParkVehicle(floorId, slotId);
        return vehicle == null ? "Invalid Ticket"
                : String.format("Unparked vehicle with Registration Number: %s and Color: %s",
                        vehicle.getRegistrationNumber(), vehicle.getColor());
    }

    VehicleType validateVehicle(String vehicleType) {
        for (VehicleType value : VehicleType.values()) {
            if (vehicleType.equals(value.name())) {
                return value;
            }
        }
        return null;
    }

    String parkVehicle(String type, String registrationNumber, String color) throws IllegalAccessException {
        VehicleType vehicleType = validateVehicle(type);
        if (vehicleType == null) {
            throw new IllegalArgumentException("Invalid vehicle type!");
        }
        ParkingSlot parkingSlot = parkingLot.parkVehicle(new Vehicle(vehicleType, registrationNumber, color));
        return parkingSlot == null ? "Parking Lot Full"
                : String.format("Parked vehicle. Ticket ID: %s", parkingSlot.getTicketId());
    }

    void display(String displayType, String type) {
        VehicleType vehicleType = validateVehicle(type);
        if (vehicleType == null) {
            throw new IllegalArgumentException("Invalid vehicle type!");
        }
        if (displayType.equals("free_count")) {
            parkingLot.displayFreeCount(vehicleType);
        } else if (displayType.equals("free_slots")) {
            parkingLot.displayFreeSlots(vehicleType);
        } else if (displayType.equals("occupied_slots")) {
            parkingLot.displayOccupiedSlots(vehicleType);
        }
    }
}
