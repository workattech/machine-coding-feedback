import service.DisplaySlots;
import service.ParkingLotService;
import utility.VehicleType;

import java.util.Scanner;

public class ParkingLotSystem {


    public static void main(String[] args) {
	// write your code here
        ParkingLotService parkingLotService = new ParkingLotService();
        DisplaySlots displaySlots = new DisplaySlots(parkingLotService);
        Scanner io = new Scanner(System.in);
        while(io.hasNextLine()) {
            String input = io.nextLine();
            String[] commands = input.trim().split(" ");
            String command = commands[0];

            switch (command) {
                case "create_parking_lot":
                    String parkingLotId = commands[1];
                    int noOfFloors = Integer.parseInt(commands[2]);
                    int noOfSlotsPerFloors = Integer.parseInt(commands[3]);
                    System.out.println(parkingLotService.createParkingLot(parkingLotId,noOfFloors,noOfSlotsPerFloors));
                    break;
                case "park_vehicle":
                    VehicleType vehicleType = VehicleType.valueOf(commands[1]);
                    String registrationNumber = commands[2];
                    String color = commands[3];
                    System.out.println(parkingLotService.parkVehicle(vehicleType,registrationNumber,color));
                    break;
                case "unpark_vehicle":
                    String parkingTicketId = commands[1];
                    System.out.println(parkingLotService.unparkVehicle(parkingTicketId));
                    break;
                case "display":
                    String displayType = commands[1];
                    VehicleType type = VehicleType.valueOf(commands[2]);
                    displaySlots.display(displayType,type);
                    break;
                case "exit":
                    System.exit(0);
                default:
                    throw new IllegalStateException("Invalid Command");
            }
        }

    }
}
