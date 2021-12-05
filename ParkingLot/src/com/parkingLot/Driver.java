package com.parkingLot;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Requirements : We can assume that there will only be 1 parking lot. The ID of that parking lot is PR1234.
        //First Command should be always create_parking_lot to create parking lot.
        String createCommand = scanner.next();
        String id = scanner.next();
        int numOfFloors = scanner.nextInt();
        int numOfSlotsPerFloor = scanner.nextInt();
        ParkingLotService parkingLotService = new ParkingLotService(id, numOfFloors, numOfSlotsPerFloor);
        boolean exitFlag = false;
        while (!exitFlag) {
            String input = scanner.next();
            switch (input) {
                case "display":
                    String displayType = scanner.next();
                    String vehicleType = scanner.next();
                    if (displayType.equals("free_count")) {
                        parkingLotService.displayFreeCountOfSlots(vehicleType);
                    } else if (displayType.equals("free_slots")) {
                        parkingLotService.displayFreeSlots(vehicleType, false);
                    } else if (displayType.equals("occupied_slots")) {
                        parkingLotService.displayFreeSlots(vehicleType, true);
                    }
                    break;
                case "park_vehicle":
                    String parkedVehicleType = scanner.next();
                    String vehicleRegistrationNumber = scanner.next();
                    String vehicleColor = scanner.next();
                    parkingLotService.parkVehicle(parkedVehicleType, vehicleRegistrationNumber, vehicleColor);
                    break;
                case "unpark_vehicle":
                    String parkedVehicleTicketId = scanner.next();
                    parkingLotService.unparkVehicle(parkedVehicleTicketId);
                    break;
                case "exit":
                    exitFlag = true;
                    System.exit(0);
            }
        }
    }
}
